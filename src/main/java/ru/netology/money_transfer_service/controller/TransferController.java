package ru.netology.money_transfer_service.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.money_transfer_service.exeption.ErrorConfirmationException;
import ru.netology.money_transfer_service.exeption.ErrorInputDataException;
import ru.netology.money_transfer_service.exeption.ErrorTransferException;
import ru.netology.money_transfer_service.pojo.CardInfo;
import ru.netology.money_transfer_service.pojo.ConfirmationInfo;
import ru.netology.money_transfer_service.service.TransferService;

@Slf4j
@RestController
@CrossOrigin
public class TransferController {
    private static final Logger log = LoggerFactory.getLogger(TransferController.class);
    private TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(@RequestBody @Valid CardInfo cardInfo) {
        transferService.setCardInfo(cardInfo);
        return new ResponseEntity<>("Вам направлен код подтверждения на телефон", HttpStatus.OK);
    }

    @PostMapping("/confirmOperation")
    public ResponseEntity<String> confirmationOperation(@RequestBody @Valid ConfirmationInfo confirmationOperation) {
        CardInfo cardInfo = transferService.getCardInfo();
        log.info("Перевод с карты {} на карту {}. Сумма списания: {} {}. Сумма комиссии: {} Результат операции - успешно! ",
                cardInfo.getCardFromNumber(),
                cardInfo.getCardToNumber(),
                cardInfo.getAmount().getValue(),
                cardInfo.getAmount().getCurrency(),
                Math.round(cardInfo.getAmount().getValue() * 0.01)
        );
        return new ResponseEntity<>("Перевод успешно выполнен", HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<String> invalidInputData(ErrorInputDataException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> errorTransfer(ErrorTransferException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<String> errorConfirmation(ErrorConfirmationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
