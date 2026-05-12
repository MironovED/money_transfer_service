package ru.netology.money_transfer_service.pojo;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

//todo Добавить валидацию полей если буду успевать - jakarta
/**
 * ДТО на сумму перевода и валюта
 */
@Getter
@Setter
public class AmountInfo {
    /** Сумма перевода */
    @NotBlank
    private Integer value;

    /** Валюта */
    @NotBlank
    private String currency;

    public AmountInfo() {
    }

    public AmountInfo(Integer value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "AmountInfo{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}
