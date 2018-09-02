package interview;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by nazar on 4/9/2017.
 */
public class Interview {
    private int count;
    private String name;
    public static final int number;

    static {
        number = 10;
    }

    public Interview(int count, String name) {
        this.count = count;
        this.name = name;
    }

    public Interview(String name, int count) {
        this.count = count;
        this.name = name;
    }

    public Interview(String name) {
           this.name = name;
    }

    public Interview(int count) {
        this.count = count;
        String text = "line";
        text = text + "new line";
    }

   /* public static void change(String... name, int count) {
//        name.concat("Hello");
    }*/

    public static void main(String[] args) {
        String world = "World";
//        change(world);
        int f = 12;
        byte b = (byte) f;
        int i = b;

        int a = 1;

        int y = ++a + a++ + a-- + ++a - --a;//2 + 2 + 3 + 3 - 2
        System.out.println(y);

//        int[] array = {1,2,3};
//        int[] array = new int[]{1, 2, 3};

        int[][] array1 = {
                {1, 2, 3},
                {1, 2, 3, 4, 5, 6},
                {1, 2}
        };

        ArrayList integers = new ArrayList<>();
        integers.add("");
        integers.add(3);
        integers.add(new File(""));
    }

    interface Ballable {

    }

}
