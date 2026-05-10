package ru.netology.money_transfer_service.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Подтверждение операции перевода денег
 */
@Getter
@Setter
public class ConfirmationOperation {
    /** Идентификатор операции */
    private String operationId;
    /** Код подтверждения */
    private String code;

    private ConfirmationOperation(String operationId, String code) {
        this.operationId = operationId;
        this.code = code;
    }
}
