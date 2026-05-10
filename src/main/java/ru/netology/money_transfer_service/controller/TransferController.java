package ru.netology.money_transfer_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.money_transfer_service.pojo.CardInfo;
import ru.netology.money_transfer_service.pojo.ConfirmationOperation;
import ru.netology.money_transfer_service.service.TransferService;
import ru.netology.money_transfer_service.service.TransferServiceImpl;

@RestController
public class TransferController {
    private TransferService transferService;

    public TransferController(TransferServiceImpl transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(@RequestBody CardInfo cardInfo) {
        return null;
    }

    @PostMapping("/confirmOperation")
    public ResponseEntity<String> confirmationOperation(@RequestBody ConfirmationOperation confirmationOperation) {
        return null;
    }

}
