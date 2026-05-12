package ru.netology.money_transfer_service.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Setter;

@Setter
public class CardInfo {
    /** Номер карты, с которой осуществляется перевод */
    @NotBlank
    @Pattern(regexp = "\\d{16}", message = "Номер карты должен содержать ровно 16 цифр")
    private String cardFromNumber;

    /** Дата действия карты, с которой осуществляется перевод */
    @NotBlank
    private String cardFromValidTill;

    /** Код CVV карты, с которой осуществляется перевод */
    @NotBlank
    @Pattern(regexp = "\\d{3}", message = "Код CVV должен содержать 3 цифры")
    private String cardFromCVV;

    /** Номер карты, на которую осуществляется перевод */
    @NotBlank
    @Pattern(regexp = "\\d{16}", message = "Номер карты должен содержать ровно 16 цифр")
    private String cardToNumber;

    /** Сумма перевода - сумма и валюта */
    @NotNull
    private AmountInfo  amount;

    public CardInfo() {}

    public CardInfo(
            String cardFromNumber,
            String cardFromValidTill,
            String cardFromCVV,
            String cardToNumber,
            AmountInfo amount
            ) {
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.cardToNumber = cardToNumber;
        this.amount = amount;
    }

    public String getCardFromNumber() {
        return cardFromNumber;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }

    public AmountInfo getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "CardInfo{" +
                "cardFromNumber='" + cardFromNumber + '\'' +
                ", cardFromValidTill='" + cardFromValidTill + '\'' +
                ", cardFromCVV='" + cardFromCVV + '\'' +
                ", cardToNumber='" + cardToNumber + '\'' +
                ", amount=" + amount.toString() +
                '}';
    }
}
