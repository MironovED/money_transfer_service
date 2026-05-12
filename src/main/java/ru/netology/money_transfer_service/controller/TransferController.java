package ru.netology.money_transfer_service.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.money_transfer_service.pojo.CardInfo;
import ru.netology.money_transfer_service.pojo.ConfirmationInfo;
import ru.netology.money_transfer_service.service.TransferService;
import ru.netology.money_transfer_service.service.TransferServiceImpl;

@Slf4j
@RestController
@CrossOrigin
public class TransferController {
    private TransferService transferService;

    public TransferController(TransferServiceImpl transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(@RequestBody @Valid CardInfo cardInfo) {
        System.out.println(cardInfo.toString());
        return null;
    }

    @PostMapping("/confirmOperation")
    public ResponseEntity<String> confirmationOperation(@RequestBody @Valid ConfirmationInfo confirmationOperation) {
        return null;
    }

}
