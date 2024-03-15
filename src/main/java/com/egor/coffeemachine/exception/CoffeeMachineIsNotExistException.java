package com.egor.coffeemachine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Coffee machine does not exist!") // 404 Not Found
public class CoffeeMachineIsNotExistException extends RuntimeException {
    public CoffeeMachineIsNotExistException() {
        super();
    }

    public CoffeeMachineIsNotExistException(String message) {
        super(message);
    }

    public CoffeeMachineIsNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoffeeMachineIsNotExistException(Throwable cause) {
        super(cause);
    }

    protected CoffeeMachineIsNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
