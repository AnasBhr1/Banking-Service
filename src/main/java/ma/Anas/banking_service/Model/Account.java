package ma.salman.banking_service.Model;

import ma.salman.banking_service.exception.InsufficientFundsException;
import ma.salman.banking_service.exception.InvalidAmountException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

 public class Account {
    private int balance;
    private final List<Transaction> transactions;

    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(int amount, LocalDate date) throws InvalidAmountException {
        validateAmount(amount);
        balance += amount;
        transactions.add(new Transaction(date, amount, balance));
    }

    public void withdraw(int amount, LocalDate date) throws InsufficientFundsException, InvalidAmountException {
        validateAmount(amount);
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Insufficient funds. Current balance: " + balance +
                            ", Attempted withdrawal: " + amount
            );
        }
        balance -= amount;
        transactions.add(new Transaction(date, -amount, balance));
    }

    public String printStatement() {
        StringBuilder statement = new StringBuilder();
        statement.append("Date || Amount || Balance\n");

        // Print transactions in reverse order (most recent first)
        for (int i = transactions.size() - 1; i >= 0; i--) {
            statement.append(transactions.get(i).toString()).append("\n");
        }

        return statement.toString();
    }

    public int getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    private void validateAmount(int amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Amount must be positive. Provided: " + amount
            );
        }
    }

}
