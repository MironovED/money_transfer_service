package ru.netology.money_transfer_service.service;

import org.springframework.stereotype.Service;
import ru.netology.money_transfer_service.pojo.CardInfo;

@Service
public class TransferService {
    private CardInfo cardInfo;

    public TransferService() {}

    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

    public CardInfo getCardInfo() {
        return cardInfo;
    }
}
