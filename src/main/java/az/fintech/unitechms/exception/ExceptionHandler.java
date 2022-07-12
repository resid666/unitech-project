package az.fintech.unitechms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @org.springframework.web.bind.annotation.ExceptionHandler(SameAccountException.class)
    public com.fintech.unitech.dto.ErrorResponseDto handleException(SameAccountException ex) {
        return new com.fintech.unitech.dto.ErrorResponseDto(ex.getMessage(), HttpStatus.FORBIDDEN.value());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(InsufficientBalanceException.class)
    public com.fintech.unitech.dto.ErrorResponseDto handleException(InsufficientBalanceException ex) {
        return new com.fintech.unitech.dto.ErrorResponseDto(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(InActiveAccountException.class)
    public com.fintech.unitech.dto.ErrorResponseDto handleException(InActiveAccountException ex) {
        return new com.fintech.unitech.dto.ErrorResponseDto(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler(NonExistAccountException.class)
    public com.fintech.unitech.dto.ErrorResponseDto handleException(NonExistAccountException ex) {
        return new com.fintech.unitech.dto.ErrorResponseDto(ex.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @org.springframework.web.bind.annotation.ExceptionHandler(PinAlreadyExistException.class)
    public com.fintech.unitech.dto.ErrorResponseDto handleException(PinAlreadyExistException ex) {
        return new com.fintech.unitech.dto.ErrorResponseDto(ex.getMessage(), HttpStatus.CONFLICT.value());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @org.springframework.web.bind.annotation.ExceptionHandler(CredentialsException.class)
    public com.fintech.unitech.dto.ErrorResponseDto handleException(CredentialsException ex) {
        return new com.fintech.unitech.dto.ErrorResponseDto(ex.getMessage(), HttpStatus.FORBIDDEN.value());
    }
}
