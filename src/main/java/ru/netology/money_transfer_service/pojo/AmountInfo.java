package ru.netology.money_transfer_service.pojo;

import jakarta.validation.constraints.NotBlank;
import lombok.Setter;

/**
 * ДТО на сумму перевода и валюта
 */
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

    public Integer getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "AmountInfo{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}
