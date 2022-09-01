package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

public class GenerateUtil {

    public static String generateUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length).toLowerCase();
    }

    public static double generateRandomNumber(int length) {
        String number = RandomStringUtils.randomNumeric(length);
        number = number.charAt(0) == '0' ? number.substring(1) : number;
        return Double.parseDouble(number);
    }
}
