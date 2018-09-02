package lessons.learn_class;

/**
 * Created by nazar123 on 23.11.2017.
 */
public class LearnClass {
    public static int age = 45;
    public  int agei = 45;

    static {
        System.out.println("Static block initialization");
    }

}

class TestClass {
    public static void main(String[] args) {
//        int age = new LearnClass().age;
        int age1 = LearnClass.age;

    }
}
