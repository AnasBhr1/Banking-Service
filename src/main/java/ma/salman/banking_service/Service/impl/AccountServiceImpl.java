package ma.salman.banking_service.Service.impl;

import ma.salman.banking_service.Model.Account;
import ma.salman.banking_service.Service.AccountService;
import ma.salman.banking_service.exception.InsufficientFundsException;
import ma.salman.banking_service.exception.InvalidAmountException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
@Service
public class AccountServiceImpl implements AccountService {
    private final Map<String, Account> accounts = new HashMap<>();

    @Override
    public Account getAccount(String accountId) {
        return accounts.computeIfAbsent(accountId, k -> new Account());
    }

    @Override
    public void deposit(String accountId, int amount, LocalDate date) throws InvalidAmountException {
        Account account = getAccount(accountId);
        account.deposit(amount, date);
    }

    @Override
    public void withdraw(String accountId, int amount, LocalDate date) throws InsufficientFundsException, InvalidAmountException {
        Account account = getAccount(accountId);
        account.withdraw(amount, date);
    }

    @Override
    public String getStatement(String accountId) {
        Account account = getAccount(accountId);
        return account.printStatement();
    }

    @Override
    public int getBalance(String accountId) {
        Account account = getAccount(accountId);
        return account.getBalance();
    }
}
