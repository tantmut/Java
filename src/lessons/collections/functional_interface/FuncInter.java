package lessons.collections.functional_interface;

public class FuncInter {
    public static void main(String[] args) {
        Convertable convertable = Integer::parseInt;

        Convertable convertable1 = str -> Integer.parseInt(str) + 9;

//        System.out.println(convertable.convert("8"));

        Comparable<String> comparable = (str1, str2) -> str1.length() + str2.length();

//        System.out.println(comparable.length("Hello", "World"));

        Mathable<Integer, String> mathable = (str1, str2) -> str1.length() + str2.length();

        System.out.println(mathable.length("Hell", "Wor"));
    }
}


@FunctionalInterface
interface Convertable {

    int convert(String number);

    default void convert(String age, int str) {

    }
}


@FunctionalInterface
interface Comparable<T> {
    int length(T value1, T value2);
}

@FunctionalInterface
interface Mathable<F, T> {
    F length(T value1, T value2);
}
