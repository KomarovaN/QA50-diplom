package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private DataHelper() {
    }

    public static CardInfo getCardInfoValidApproved() {
        return new CardInfo ("4444 4444 4444 4441", "08", "23", generateName("en"),"125", "APPROVED");
    }

    public static CardInfo getCardInfoValidDeclined() {
        return new CardInfo ("4444 4444 4444 4442", "08", "23",generateName("en"),"125", "DECLINED");
    }

    public static CardInfo getCardInfoInvalidNumber() {
        return new CardInfo ("4444 4444 4444", "08", "23", generateName("en"),"125", "APPROVED");
    }

    public static CardInfo getCardInfoInvalidMonth() {
        return new CardInfo ("4444 4444 4444 4441", "22", "23", generateName("en"),"125", "APPROVED");
    }

    public static CardInfo getCardInfoInvalidYear() {
        return new CardInfo ("4444 4444 4444 4441", "08", "22", generateName("en"),"125", "APPROVED");
    }

    public static CardInfo getCardInfoInvalidCVC() {
        return new CardInfo ("4444 4444 4444 4441", "08", "23", generateName("en"),"12", "APPROVED");
    }

    public static CardInfo getCardInfoInvalidOwner() {
        return new CardInfo ("4444 4444 4444 4441", "08", "23", generateName("ru"),"125", "APPROVED");
    }

    public static CardInfo getCardInfoNoNumber() {
        return new CardInfo ("", "08", "23", generateName("uk"),"125", "APPROVED");
    }

    public static CardInfo getCardInfoNoOMonth() {
        return new CardInfo ("4444 4444 4444 4441", "", "23", generateName("en"),"125", "APPROVED");
    }

    public static CardInfo getCardInfoNoYear() {
        return new CardInfo ("4444 4444 4444 4441", "08", "", generateName("en"),"125", "APPROVED");
    }

    public static CardInfo getCardInfoNoCVC() {
        return new CardInfo ("4444 4444 4444 4441", "08", "23", generateName("en"),"", "APPROVED");
    }

    public static CardInfo getCardInfoNoOwner() {
        return new CardInfo ("4444 4444 4444 4441", "08", "23", "","125", "APPROVED");
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    @Value
    public static class CardInfo {
        String cardNumber;
        String expireMonth;
        String expireYear;
        String cardOwner;
        String securityCode;
        String cardStatus;
    }
}