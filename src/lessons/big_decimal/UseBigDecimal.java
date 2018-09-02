package lessons.big_decimal;

import java.math.BigDecimal;

public class UseBigDecimal {
    public static void main(String[] args) {
        float f1 = 0.3f;

        float f2 = 0.4f;

        float f3 = 0.7f;

//        System.out.println("(f1 + f2) == f3 -> " + ((f1 + f2) == f3));

      /*  System.out.println((double) f1);
        System.out.println((double) f2);*/
        BigDecimal bd1 = new BigDecimal(f1 + f2);

        BigDecimal bd2 = new BigDecimal(f3);

        BigDecimal bigDecimal = bd1.setScale(3, BigDecimal.ROUND_UP);

        BigDecimal bigDecimal1 = bd2.setScale(3, BigDecimal.ROUND_UP);

        System.out.println(bigDecimal);
        System.out.println(bigDecimal1);

    }

}
