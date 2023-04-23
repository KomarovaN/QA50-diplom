package ru.netology.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.PayPage;
import ru.netology.page.TravelPage;

import static com.codeborne.selenide.Selenide.open;

public class TravelTest {
    TravelPage travelPage;
    @BeforeEach
    public void setup() {
        travelPage = open("http://localhost:8080", TravelPage.class);
    }

    @Test
    public void shouldPayCardValidApproved() {
        PayPage payPage = travelPage.payTravel();
        DataHelper.CardInfo cardValidApproved = DataHelper.getCardInfoValidApproved();
        payPage.validPay(cardValidApproved);
        payPage.findCloserMessageOK("Операция одобрена Банком.");
    }

}
