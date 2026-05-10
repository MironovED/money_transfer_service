package ru.netology.money_transfer_service.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Выбрасываемое исключение при ошибке перевода денег
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ErrorTransferException extends RuntimeException {

    public ErrorTransferException() {}

    public ErrorTransferException(String msg) {
        super(msg);
    }
}
