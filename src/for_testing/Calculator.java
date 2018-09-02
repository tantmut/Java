package for_testing;

import java.util.Random;

public class Calculator {

    public static final Random RAND = new Random();


    public int multiply(int valueOne, int valueTwo) {
        return valueOne * valueTwo;
    }

    public static int addNumbers() {
        return returnAnyNumberA() + returnAnyNumberB();
    }

    public int sumNumbers() {
        return getAnyNumberOne() + getAnyNumberTwo();
    }

    private int getAnyNumberOne() {
        return RAND.nextInt(100) + 1;
    }

    private int getAnyNumberTwo() {
        return RAND.nextInt(100) + 1;
    }

    public static int returnAnyNumberA() {
        return RAND.nextInt(100) + 1;
    }

    public static int returnAnyNumberB() {
        return RAND.nextInt(100) + 1;
    }
}
