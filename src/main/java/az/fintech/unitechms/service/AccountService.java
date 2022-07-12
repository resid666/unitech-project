package az.fintech.unitechms.service;

import az.fintech.unitechms.dto.ResultDto;
import az.fintech.unitechms.dto.AccountDto;
import az.fintech.unitechms.dto.TransferDto;

import java.util.List;

public interface AccountService {

    List<AccountDto> getUserAccounts(Long userId);

    ResultDto transfer(Long userId, TransferDto transferDto);

}
