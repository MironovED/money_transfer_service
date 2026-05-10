package ru.netology.money_transfer_service.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

//todo Добавить валидацию полей если буду успевать
@Getter
@Setter
public class CardInfo {
    /** Номер карты, с которой осуществляется перевод */
    private String cardFromNumber;
    /** Дата действия карты, с которой осуществляется перевод */
    private String cardFromValidTill;
    /** Код CVV карты, с которой осуществляется перевод */
    private String cardFromCVV;
    /** Номер карты, на которую осуществляется перевод */
    private String cardToNumber;
    /** Сумма перевода - сумма и валюта */
    private Map<Integer, String>  amount;

    public CardInfo() {}

    public CardInfo(
            String cardFromNumber,
            String cardFromValidTill,
            String cardFromCVV,
            String cardToNumber,
            Map<Integer, String> amount
            ) {
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.cardToNumber = cardToNumber;
        this.amount = amount;
    }
}
