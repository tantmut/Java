package lessons.overloading_overriding;

import lessons.overloading_overriding.another_package.AnimalOO;

/**
 * Created by nazar on 3/26/2017.
 */
public class TestProtected {


    public static void printInteger(Integer integer) {
        System.out.println("Integer");
    }

    public static void printInteger(int integer) {
        System.out.println("int");
    }

    public static void main(String[] args) {
        AnimalOO animalOO = new AnimalOO();
        CatOO catOO = new CatOO();
//        catOO.getNumber();
//        animalOO.getNumber();
        printInteger(5);
        printInteger(new Integer(5));
    }
}
