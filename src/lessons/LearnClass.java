package lessons;


public class LearnClass {
    public static final int COUNT = 15;
    private static String firstName = "FirstName";

    static {
//        COUNT = 15;
//        System.out.println("Static block initializatoin");
//        System.out.println("Hello World");
        firstName = "Hello World";
    }

    private int countOfChildren;
    private String name;

    {
//         COUNT = 15;
//        name = "Hello";
//        System.out.println("Not static block initializatoin");
    }

    public LearnClass(int count, String name) {
//        System.out.println("Constructor");
        this.countOfChildren = count;
        this.name = name;
    }

   /* public void changeVariable(int a) {
        a = 15;
    } */

    /*public void changeVariable(String a) {
        a = "Run";// a = new String("Run")
    }*/

    /*public void changeVariable(Integer a) {
        a = 12;// a = new Integer(12)
    }*/

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        LearnClass.firstName = firstName;
    }

    public static void main(String... args) {
        LearnClass learnClass = new LearnClass(1, "23");//(this, 1, 23)
       /* int a = 26;
        learnClass.changeVariable(a);*/
//        String string = "Hello";
//        learnClass.changeVariable(string);
//        System.out.println(string);
        Integer a = 15;
        int b = 2;
        learnClass.changeVariable(a, 1, b, 56, 78);
//        System.out.println(a);
        System.out.println(LearnClass.getFirstName());
       /*LearnClass learnClass1 = learnClass;
       learnClass1.setCountOfChildren(250);
        System.out.println(learnClass.getCountOfChildren());*/
       /*int a = 10;
       int b = a;*/
//        LearnClass learnClass = null;//(this, 1, 23)
//        learnClass = new LearnClass(1, "23");//(this, 1, 23)

        /*LearnClass.firstName = "Run";*/
//        learnClass.countOfChildren = -100;

//        System.out.println(learnClass.firstName);

//        learnClass.setCountOfChildren(15);//(this, 15)

//        LearnClass learnClass1 = new LearnClass(2, "24");

//        learnClass1.setCountOfChildren(18);//(this, 18)

//        System.out.println(LearnClass.firstName);

    }

    public void changeVariable(Integer... a) {
//        COUNT = 45;
//        a = 12;// a = new Integer(12)
        int length = a.length;
    }

    public void print(final int number) {
        int number1 = number;
        number1 = 15;
    }

    public int getCountOfChildren() {
        return countOfChildren;
    }

    public void setCountOfChildren(int countOfChildren) {
        this.countOfChildren = countOfChildren;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
