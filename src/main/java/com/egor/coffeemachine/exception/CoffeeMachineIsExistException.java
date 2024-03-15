package com.egor.coffeemachine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Duplicate coffee machine!") // 409 Conflict
public class CoffeeMachineIsExistException extends RuntimeException {
    public CoffeeMachineIsExistException() {
        super();
    }

    public CoffeeMachineIsExistException(String message) {
        super(message);
    }

    public CoffeeMachineIsExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoffeeMachineIsExistException(Throwable cause) {
        super(cause);
    }

    protected CoffeeMachineIsExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
