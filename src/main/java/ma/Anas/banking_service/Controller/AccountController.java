package ma.salman.banking_service.Controller;

import jakarta.validation.Valid;
import ma.salman.banking_service.Service.AccountService;
import ma.salman.banking_service.dto.AccountResponse;
import ma.salman.banking_service.dto.DepositRequest;
import ma.salman.banking_service.dto.WithdrawRequest;
import ma.salman.banking_service.exception.InsufficientFundsException;
import ma.salman.banking_service.exception.InvalidAmountException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{accountId}/deposit")
    public ResponseEntity<AccountResponse> deposit(
            @PathVariable String accountId,
            @Valid @RequestBody DepositRequest request) throws InvalidAmountException {

        accountService.deposit(accountId, request.getAmount(), request.getDate());
        int newBalance = accountService.getBalance(accountId);

        return ResponseEntity.ok(new AccountResponse(
                newBalance,
                "Deposit successful"
        ));
    }

    @PostMapping("/{accountId}/withdraw")
    public ResponseEntity<AccountResponse> withdraw(
            @PathVariable String accountId,
            @Valid @RequestBody WithdrawRequest request) throws InsufficientFundsException, InvalidAmountException {

        accountService.withdraw(accountId, request.getAmount(), request.getDate());
        int newBalance = accountService.getBalance(accountId);

        return ResponseEntity.ok(new AccountResponse(
                newBalance,
                "Withdrawal successful"
        ));
    }

    @GetMapping("/{accountId}/statement")
    public ResponseEntity<AccountResponse> getStatement(
            @PathVariable String accountId) {

        String statement = accountService.getStatement(accountId);
        return ResponseEntity.ok(new AccountResponse(statement));
    }

    @GetMapping("/{accountId}/balance")
    public ResponseEntity<AccountResponse> getBalance(
            @PathVariable String accountId) {

        int balance = accountService.getBalance(accountId);
        return ResponseEntity.ok(new AccountResponse(
                balance,
                "Current balance"
        ));
    }

}
