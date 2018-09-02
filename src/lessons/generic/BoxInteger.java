package lessons.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nazar123 on 11.02.2018.
 */
public class BoxInteger {
    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

class BoxDouble {
    private Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}

class Box<T, F, E> {
    private T value;
    private F value1;
    private E value2;

    public T  getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class ClassWithGenericMethod {
    public static <E> void print(E[] list) {
        System.out.println(Arrays.toString(list));
    }

    public static void main(String[] args) {

        ClassWithGenericMethod.<Integer>print(new Integer[]{1, 2, 5});
        print(new Double[]{1.0, 2.0, 5.0});
    }
}

class BoundedType {
    public static<E extends Comparable<E>> int compareObjects(E a, E b) {//String
       return a.compareTo(b);//Comparable<E>
    }

    public static  <E extends Number> int comparingNumbers(E v1, E v2) {
        return v1.intValue() + v2.intValue();
    }

    public static void main(String[] args) {
//        System.out.println(compareObjects("dld", "df"));
        System.out.println(comparingNumbers(5, 7));
    }
}


class WildCards {

    public static Integer findMax (List<? extends Number> numbers) {
        return 0;
    }


    public static void main(String[] args) {
        List<Double> integers = Arrays.asList(1.0, 2.0, 3.0);

        findMax(integers);
    }
}


class BoxTest {
    public static void main(String[] args) {
        Box<Integer, String, Double> integerBox = new Box<>();

//        Box<Double> doubleBox = new Box<>();

        List<Integer> list = new ArrayList();

        list.add(5);
//        list.add("Hello");

        for (Object o : list) {
            System.out.println((Integer) o);
        }
    }
}
