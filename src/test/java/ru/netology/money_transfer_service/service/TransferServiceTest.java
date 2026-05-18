package ru.netology.money_transfer_service.service;

import org.junit.jupiter.api.Test;
import ru.netology.money_transfer_service.pojo.AmountInfo;
import ru.netology.money_transfer_service.pojo.CardInfo;

import static org.junit.jupiter.api.Assertions.*;

class TransferServiceTest {

    @Test
    void getCardInfo() {
        CardInfo cardInfo = new CardInfo(
                "1234567812345678",
                "11/27",
                "123",
                "1234567812345678",
                new AmountInfo(1000, "RUB")
        );

        TransferService transferService = new TransferService();
        transferService.setCardInfo(cardInfo);

        assertEquals(transferService.getCardInfo().toString(), cardInfo.toString());
    }
}