package az.fintech.unitechms.exception;

public class NonExistAccountException extends RuntimeException {

    public NonExistAccountException(String message) {
        super(message);
    }
}
