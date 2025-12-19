package ma.salman.banking_service.exception;

public class InsufficientFundsException extends Throwable {
    public InsufficientFundsException(String s) {
        super(s);
    }
}
