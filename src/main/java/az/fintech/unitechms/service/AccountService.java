package az.fintech.unitechms.service;

import az.fintech.unitechms.dto.ResultDto;
import com.fintech.unitech.dto.AccountDto;
import com.fintech.unitech.dto.TransferDto;

import java.util.List;

public interface AccountService {

    List<AccountDto> getUserAccounts(Long userId);

    ResultDto transfer(Long userId, TransferDto transferDto);

}
