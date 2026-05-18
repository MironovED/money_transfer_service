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
    /** Код подтверждения */
    @NotNull
    private String code;

    public ConfirmationInfo(String code) {
        this.code = code;
    }
}
