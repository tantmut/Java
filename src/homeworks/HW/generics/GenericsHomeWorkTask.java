package homeworks.HW.generics;

import org.junit.Assert;
import org.junit.Test;


public class GenericsHomeWorkTask {

    @Test
    public void test() {
        Integer[] arrayInt = {1, 2, 3, 4, 5};
        Double[] arrayDouble = {1.5, 2.9, 3.3, 9.5};


        Assert.assertEquals(3, methodCalcNum(arrayInt, 2));
        Assert.assertEquals(2, methodCalcNum(arrayDouble, 3.0));
    }


    public static <T extends Number> int methodCalcNum(T[] array, T maxElem) {
        int count = 0;

        for (T el : array) {

            if (el.doubleValue() > maxElem.doubleValue()) {
                count++;
            }
        }

        return count;
    }

    public static <T extends Number> void main(T value) {

        int count = 0;
        int count1 = 0;
        Integer[] arrayInt = {5, 6, 7};
        Double[] arrayDoube = {5.5, 6.6, 7.2};

        for (int el : arrayInt) {

            if (el > (Integer) value) {
                count++;
            }
        }

        for (int i = 0; i < arrayInt.length; i++) {

        }

        System.out.println(count + " and " + count1);

    }
}


