package homeworks.HW.patterns;

public class Template {
    public static void main(String[] args) {

        A a = new A();
        B b = new B();
        C c = new C();
        a.print();
        b.print();
        c.print();

    }
}

class A extends Same{

    @Override
    void differ() {
        System.out.println("\t  *********");
    }
}

class B extends Same{

    @Override
    void differ() {
        System.out.println("" +
                "          *******\n" +
                "          *******\n" +
                "          *******\n" +
                "          *******");

    }
}

class C extends Same{

    @Override
    void differ() {
        System.out.println("     ***\n" +
                "         ***\n" +
                "      **********\n" +
                "      **********\n" +
                "         ***\n" +
                "         ***");

    }
}

abstract class Same {

    public void print(){
        System.out.println("\t\t\t*\n" +
                "         ***\n" +
                "        *****\n" +
                "       *******\n" +
                "      *********");
        System.out.println();
        System.out.println();

        differ();
        System.out.println();
        System.out.println();
        System.out.println("\t\t\t*\n" +
                "         ***\n" +
                "        *****\n" +
                "       *******\n" +
                "      *********");

    }

    abstract void differ();
}