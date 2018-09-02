package homeworks.HW;

/**
 * Created by nazar on 2/26/2017.
 */
public class FindQuantityEl {

    public static void main(String[] args) {
        String hi = "Hello world";
        char el = 'l';
        int result = 0;

        for (int i = 0; i < hi.length(); i++) {
            if (hi.charAt(i) == el) {
                result++;
            }
        }

        System.out.print(result + "\n" + hi.replace("Hello", "Goodbye"));
    }
}