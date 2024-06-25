package helpers;

import java.util.Random;

public class Helps {

    public static String generateRandomEmail() {
        Random random = new Random();
        int randomNumber = random.nextInt(100000);
        return "test" + randomNumber + "@gmail.com";
    }
}
