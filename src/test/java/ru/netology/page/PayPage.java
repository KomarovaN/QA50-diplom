package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PayPage {
    private SelenideElement headerPay = $(byText("Оплата по карте"));
    //private SelenideElement headerCredit = $(byText("Кредит по данным карты"));
    private SelenideElement numberField = $(".input__control", 0);
    private SelenideElement monthField = $(".input__control", 1);
    private SelenideElement yearField = $(".input__control", 2);
    private SelenideElement ownerField = $(".input__control", 3);
    private SelenideElement secretcodeField = $(".input__control", 4);
    private SelenideElement continueButton = $(byText("Продолжить"));
    private static SelenideElement errorMessage = $(".input__sub");
    private static SelenideElement closerMessageOK = $(".notification__content",0);
    private static SelenideElement closerMessageError = $(".notification__content",1);
    //.notification_status_error  .notification__title "Ошибка" .notification__content "Ошибка! Банк отказал в проведении операции."
    //.notification_status_ok  .notification__title "Успешно" .notification__content "Операция одобрена Банком."

    public PayPage() {
        headerPay.shouldBe(visible);
    }

    public void validPay(DataHelper.CardInfo cardInfo) {
        numberField.setValue(cardInfo.getCardNumber());
        monthField.setValue(cardInfo.getExpireMonth());
        yearField.setValue(cardInfo.getExpireYear());
        ownerField.setValue(cardInfo.getCardOwner());
        secretcodeField.setValue(cardInfo.getSecurityCode());
        continueButton.click();
    }

    public void findErrorMessage(String textMessage) {
        errorMessage.shouldHave(exactText(textMessage), Duration.ofSeconds(10)).shouldBe(visible);
    }

    public void findCloserMessageOK(String textMessage) {
        closerMessageOK.shouldHave(exactText(textMessage), Duration.ofSeconds(10)).shouldBe(visible);
    }

    public void findCloserMessageError(String textMessage) {
        closerMessageError.shouldHave(exactText(textMessage), Duration.ofSeconds(10)).shouldBe(visible);
    }
}
