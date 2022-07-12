package az.fintech.unitechms.exception;

public class SameAccountException extends RuntimeException {

    public SameAccountException(String message) {
        super(message);
    }
}
