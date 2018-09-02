package homeworks.HW;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CalculateWordsWithMap {

    public static void main(String[] args) {

        String check = "Nazar I go to school Go to Nazar to";

        Map<String, Integer> map = new HashMap<>();

        /*for (String s : check.split(" ")) {
            int i = 0;
            if (!map.containsKey(s)) {
                map.put(s, ++i);
            } else {
                int v = map.get(s);
                map.replace(s, ++v);
            }
        }*/

        Arrays.stream(check.split(" ")).forEach(word -> {

            int i = 0;

            if (map.containsKey(word)) {
                i = map.get(word);
            }

            map.put(word, ++i);

        });

        map.forEach((k, v)
                -> System.out.println("Item : " + "-" + k + "-" + " .Count : " + v));

    }
}
