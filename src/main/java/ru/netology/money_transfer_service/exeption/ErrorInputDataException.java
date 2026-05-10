package ru.netology.money_transfer_service.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Выбрасываемое исключение при ошибке запроса
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ErrorInputDataException extends RuntimeException {

    public ErrorInputDataException() {}

    public ErrorInputDataException(String msg) {
        super(msg);
    }
}
