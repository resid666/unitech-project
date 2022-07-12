package az.fintech.unitechms.controller;

import az.fintech.unitechms.dto.ResultDto;
import az.fintech.unitechms.service.AccountService;
import az.fintech.unitechms.dto.AccountDto;
import az.fintech.unitechms.dto.TransferDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{user_id}/accounts")
    public List<AccountDto> getUserAccounts(@PathVariable("user_id") Long userId) {
        return accountService.getUserAccounts(userId);
    }

    @PostMapping("/{user_id}/accounts/transfers")
    public ResponseEntity<ResultDto> transfer(@PathVariable("user_id") Long userId,
                                              @RequestBody TransferDto transferDto) {
        return ResponseEntity.ok(accountService.transfer(userId, transferDto));
    }
}
