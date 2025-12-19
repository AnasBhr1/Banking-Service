package ma.salman.banking_service.dto;

public class AccountResponse {
    private int balance;
    private String message;
    private String statement;

    public AccountResponse() {}

    public AccountResponse(int balance, String message) {
        this.balance = balance;
        this.message = message;
    }

    public AccountResponse(String statement) {
        this.statement = statement;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }
}
