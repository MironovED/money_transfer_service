package ru.netology.money_transfer_service.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Выбрасываемое исключение при подтверждении операции
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ErrorConfirmationException extends RuntimeException{

    public ErrorConfirmationException() {}

    public ErrorConfirmationException(String msg) {
        super(msg);
    }
}
