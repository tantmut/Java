package homeworks.HW;

/**
 * Created by nazar on 2/26/2017.
 */
public class TableOfMultiplication {
    public static void main(String[] args) {

      /*  String[][] twoD; // объявили двухмерный массив
        twoD = new String[11][11];*/

        int[][] twoD = new int[11][11];

        int length = twoD.length;
        for (int i = 1; i < length; i++) {
            for (int j = 1; j <= length; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }
}

