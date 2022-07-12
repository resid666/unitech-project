package az.fintech.unitechms.service.impl;

import az.fintech.unitechms.dto.ResultDto;
import az.fintech.unitechms.exception.InActiveAccountException;
import az.fintech.unitechms.exception.InsufficientBalanceException;
import az.fintech.unitechms.exception.NonExistAccountException;
import az.fintech.unitechms.exception.SameAccountException;
import az.fintech.unitechms.service.AccountService;
import com.fintech.unitech.domain.Account;
import com.fintech.unitech.domain.Transfer;
import com.fintech.unitech.dto.AccountDto;
import com.fintech.unitech.dto.TransferDto;
import com.fintech.unitech.enumeration.AccountStatus;
import com.fintech.unitech.repository.AccountRepository;
import com.fintech.unitech.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<AccountDto> getUserAccounts(Long userId) {
        return accountRepository.findAccountByUserIdAndStatus(userId, AccountStatus.ACTIVE).stream()
                .map(account -> modelMapper.map(account, AccountDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ResultDto transfer(Long userId, TransferDto transferDto) {

        Account fromAccount = accountRepository.findByIdAndUserId(transferDto.getFromAccount(), userId).orElseThrow(
                () -> new NonExistAccountException(
                        "Authorized user does not have account"));
        if (fromAccount.getBalance() < transferDto.getAmount())
            throw new InsufficientBalanceException("Please check your balance");
        if (fromAccount.getStatus().equals(AccountStatus.INACTIVE))
            throw new InActiveAccountException("Couldnt to  transfer from inactive account");
        if (transferDto.getFromAccount().equals(transferDto.getToAccount()))
            throw new SameAccountException("Cant to transfer to same account");


        try {
            Account toAccount = accountRepository.getById(transferDto.getToAccount());

            if (toAccount.getStatus().equals(AccountStatus.INACTIVE))
                throw new InActiveAccountException("Account is  inactive");

            fromAccount.setBalance(fromAccount.getBalance() - transferDto.getAmount());
            toAccount.setBalance(toAccount.getBalance() + transferDto.getAmount());

            accountRepository.saveAllAndFlush(List.of(fromAccount, toAccount));
            Transfer transfer = transferRepository.save(modelMapper.map(transferDto, Transfer.class));

            return new ResultDto(transfer.getId());
        } catch (EntityNotFoundException e) {
            throw new NonExistAccountException("Account doesnt exist");
        }
    }
}
