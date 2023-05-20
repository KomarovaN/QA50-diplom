package ru.netology.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.DBHelper;
import ru.netology.data.DataHelper;
import ru.netology.page.PayPage;
import ru.netology.page.TravelPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DBHelper.cleanDB;

public class DBTest {
    TravelPage travelPage;
    @BeforeEach
    public void setup() {
        travelPage = open("http://localhost:8080", TravelPage.class);
    }
    @AfterAll
    static void setDown() { cleanDB(); }

    @Test
    @DisplayName("Should be successful payment with approved status")
    void shouldApprovedStatusPayment() {
        PayPage payPage = travelPage.payTravel();
        DataHelper.CardInfo cardValidApproved = DataHelper.getCardInfoValidApproved();
        payPage.validPay(cardValidApproved);
        DataHelper.CardStatus cardStatus = DBHelper.getCardStatusPay();
        String actualStatus = cardStatus.getStatus();
        String expectedStatus = "APPROVED";
        assertEquals (expectedStatus, actualStatus);
    }

    @Test
    @DisplayName("Should be successful credit request with approved status")
    void shouldApprovedStatusCreditRequest() {
        PayPage creditPage = travelPage.creditTravel();
        DataHelper.CardInfo cardValidApproved = DataHelper.getCardInfoValidApproved();
        creditPage.validPay(cardValidApproved);
        DataHelper.CardStatus cardStatus = DBHelper.getCardStatusCredit();
        String actualStatus = cardStatus.getStatus();
        String expectedStatus = "APPROVED";
        assertEquals (expectedStatus, actualStatus);
    }

    @Test
    @DisplayName("Should be payment with declined status")
    void shouldDeclinedStatusPayment() {
        PayPage payPage = travelPage.payTravel();
        DataHelper.CardInfo cardValidDeclined = DataHelper.getCardInfoValidDeclined();
        payPage.validPay(cardValidDeclined);
        DataHelper.CardStatus cardStatus = DBHelper.getCardStatusPay();
        String actualStatus = cardStatus.getStatus();
        String expectedStatus = "DECLINED";
        assertEquals (expectedStatus, actualStatus);
    }

    @Test
    @DisplayName("Should be credit request with declined status")
    void shouldDeclinedStatusCreditRequest() {
        PayPage creditPage = travelPage.creditTravel();
        DataHelper.CardInfo cardValidDeclined = DataHelper.getCardInfoValidDeclined();
        creditPage.validPay(cardValidDeclined);
        DataHelper.CardStatus cardStatus = DBHelper.getCardStatusCredit();
        String actualStatus = cardStatus.getStatus();
        String expectedStatus = "DECLINED";
        assertEquals (expectedStatus, actualStatus);
    }
}
