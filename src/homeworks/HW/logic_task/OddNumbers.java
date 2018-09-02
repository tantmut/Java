package homeworks.HW.logic_task;

/**
 * Created by nazar123 on 05.02.2018.
 */
public class OddNumbers {

//    2) Между двумя числами l и r найти все нечетные числа и положить их в массив. Вернуть массив без нулей.

    public int[] oddNumbers(int a, int b) {

        int len = 0;

        for (int i = a; i <= b; i++) {

            if (i % 2 != 0) {
                len++;
            }
        }

        int[] result = new int[len];

        for (int i = a, j = 0; i <= b; i++, ++j) {
            if (i % 2 != 0) {
                result[j] = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        OddNumbers c = new OddNumbers();

        int[] result = c.oddNumbers(5, 12);
        int[] result1 = c.oddNumbers(5, 18);
        int[] result2 = c.oddNumbers(5, 9);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println("\n");

        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");

        }
        System.out.println("\n");

        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }
    }
}
