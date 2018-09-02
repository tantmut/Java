package lessons;

public class Wrapper {
    public static void main(String[] args) {
        int count = 10;//new Integer(10)
        Integer number = 15;

        count = number;//int number = 15; unboxing

        number = count;//autoboxing

        int countNumber = number.parseInt("89");

    }
}
