package homeworks.HW.logic_task;

/**
 * Created by nazar123 on 05.02.2018.
 */
public class ConnectTwoString {

    public String connect(String a, String b) {

        String result = "";
        String[] arrayA = a.split("");
        String[] arrayB = b.split("");
        int len = arrayA.length >= arrayB.length ? arrayA.length : arrayB.length;

        for (int i = 0; i < len; i++) {

            if (arrayA.length - 1 < i    ) {
                result += "";
            } else {
                result += arrayA[i];
            }

            if (arrayB.length - 1 < i) {
                result += "";
            } else {
                result += arrayB[i];
            }
        }

        return result;
    }
//    ("abc", "drf") результат: ("adbrcf"), ("ab", "drf") результат: ("adbrf), ("abc", "dr") результат: ("adbrc")

    public static String mergeStrings(String str1, String str2) {

        int length = Math.abs(str2.length() - str1.length());//abc "bf "

        StringBuilder builder1 = new StringBuilder(str1);

        StringBuilder builder2 = new StringBuilder(str2);

        if(str1.length() < str2.length()) {

            for (int i = 0; i < length; i++) {
                builder1.append(" ");
            }
        } else if(str1.length() > str2.length()) {

            for (int i = 0; i < length; i++) {
                builder2.append(" ");
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < builder1.length(); i++) {
            result.append(builder1.charAt(i)).append(builder2.charAt(i));
        }

        return result.toString().replaceAll(" ", "");
    }

    public static void main(String[] args) {

        ConnectTwoString c = new ConnectTwoString();

        String result = c.connect("abc", "drf");
        String result1 = c.connect("ab", "drf");
        String result2 = c.connect("abc", "dr");

        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
    }
}
