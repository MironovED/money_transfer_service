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
    /** Идентификатор операции, почему то в api указан, но фронт отправляет только код
    @NotNull
    private String operationId;
     */

    /** Код подтверждения */
    @NotNull
    private String code;

    public ConfirmationInfo(String code) {
        this.code = code;
    }
}
