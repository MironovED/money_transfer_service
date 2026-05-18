package ru.netology.money_transfer_service.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import ru.netology.money_transfer_service.pojo.CardInfo;
import ru.netology.money_transfer_service.service.TransferService;

import static org.junit.jupiter.api.Assertions.*;

class TransferControllerTest {

    @Test
    void shouldReturnHttpCode200() {
        TransferService service = Mockito.mock(TransferService.class);
        CardInfo cardInfo = Mockito.mock(CardInfo.class);

        TransferController controller = new TransferController(service);
        var responseEntity = controller.transferMoney(cardInfo);

        assertEquals("Вам направлен код подтверждения на телефон", responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}