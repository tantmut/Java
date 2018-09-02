package lessons.generic.wildcards;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nazar123 on 11.02.2018.
 */
public class Parent extends AbstractParent {
}

class AbstractParent {
}

class Child1 extends Parent {
}

class Child2 extends Parent {
}


class TestWildCards {

    public static void print(List<? extends Parent> parents) {

    }

    public static void print1(List<? super Parent> parents) {

    }

    public static void print2(List<?> parents) {

    }

    public static void main(String[] args) {


        AbstractParent abstractParent = new AbstractParent();

        Parent parent = new Parent();

        Child1 child1 = new Child1();
        Child2 child2 = new Child2();

        List<Parent> parents = Arrays.asList(new Parent());
        List<AbstractParent> aparents = Arrays.asList(new AbstractParent());
        List<Child1> child1s = Arrays.asList(new Child1());

//        print2();
    }
}
