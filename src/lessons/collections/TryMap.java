package lessons.collections;

import java.util.HashMap;
import java.util.Map;

public class TryMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "One");
        map.put(2, "Second");

        System.out.println(map.entrySet());
    }
}
