package ru.netology.money_transfer_service.pojo;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Подтверждение операции перевода денег
 */
@Getter
@Setter
public class ConfirmationInfo {
    /** Идентификатор операции */
    @NotNull
    private String operationId;

    /** Код подтверждения */
    @NotNull
    private String code;

    private ConfirmationInfo(String operationId, String code) {
        this.operationId = operationId;
        this.code = code;
    }
}
