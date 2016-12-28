package utils;

import java.util.Random;

public class RandomGenerator {
    public static String generateNewGameID() {
        // Generates a new random gameID of length 10.
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuffer randomString = new StringBuffer();
        for(int x=0; x<=10; x++) {
            Random random=new Random();
            int val = random.nextInt(str.length());
            randomString.append(str.charAt(val));
        }
        return new String(randomString);
    }
}
