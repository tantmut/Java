package lessons.learn_inner_class;

class Outer {
    private int age;
    private static String name = "John";

    class Inner {

        public static final int AGE = 10;

        public void print() {
            System.out.println(age + name);
        }
    }

    static class StaticInnerClass {

        public static int AGE = 10;

        public void print() {
//            System.out.println(age  + name);
        }
    }

    public void foo(String name1) {


        /*for (;;) {
            class Foo {

            }
        }*/

        class LocalClass {
            public static final int AGE = 45;

            public void print() {
                System.out.println(age + name1);
            }
        }

//        name1 = "";
    }

}

class TestInner {
    public static void main(String[] args) {
        Outer outer = new Outer();

        Outer.Inner inner = outer.new Inner();

        inner.print();

        Outer.StaticInnerClass aClass = new Outer.StaticInnerClass();
    }
}
