package ma.salman.banking_service.Service;
import ma.salman.banking_service.Model.Account;
import ma.salman.banking_service.exception.InsufficientFundsException;
import ma.salman.banking_service.exception.InvalidAmountException;

import java.time.LocalDate;

public interface AccountService {
    Account getAccount(String accountId);
    void deposit(String accountId, int amount, LocalDate date) throws InvalidAmountException;
    void withdraw(String accountId, int amount, LocalDate date) throws InsufficientFundsException, InvalidAmountException;
    String getStatement(String accountId);
    int getBalance(String accountId);
}
