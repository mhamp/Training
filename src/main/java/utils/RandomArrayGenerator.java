package utils;

import java.util.Random;

public class RandomArrayGenerator {

    public static int[] getRandomArray(int length) {
        Random rand = new Random();
        int[] numbers = new int[100000000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000000000);
        }
        return numbers;
    }
}
