package ru.netology.money_transfer_service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import ru.netology.money_transfer_service.pojo.AmountInfo;
import ru.netology.money_transfer_service.pojo.CardInfo;
import ru.netology.money_transfer_service.pojo.ConfirmationInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MoneyTransferServiceApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	private static final GenericContainer<?> app = new GenericContainer<>("app:latest")
			.withExposedPorts(5500);

	@BeforeAll
	public static void setUp() {
		app.start();
	}

	@Test
	void shouldResponseSuccess() {
		CardInfo cardInfo = new CardInfo(
				"1234567812345678",
				"11/27",
				"123",
				"1234567812345678",
				new AmountInfo(1000, "RUB")
		);

		HttpEntity<CardInfo> requestBodyTransfer = new HttpEntity<>(cardInfo);
		ResponseEntity<String> responseTransfer = restTemplate.exchange(
				"/transfer",
				HttpMethod.POST,
				requestBodyTransfer,
				String.class    			// Класс, в который нужно распарсить тело ответа
		);

		ConfirmationInfo confirmInfo = new ConfirmationInfo("12345");
		HttpEntity<ConfirmationInfo> requestBodyConfirm = new HttpEntity<>(confirmInfo);
		ResponseEntity<String> responseConfirm = restTemplate.exchange(
				"/confirmOperation",
				HttpMethod.POST,
				requestBodyConfirm,
				String.class
		);

		assertEquals(HttpStatus.OK, responseConfirm.getStatusCode());
	}
}
