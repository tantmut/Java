package homeworks.HW.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolveGenerics {

    @Test
    public  void boxesTest(){
        List<Box<String>> boxes = new ArrayList<>();

        Box<String> box = new Box<>();
        box.setObj("a string");

        Box<String> box2 = new Box<>();
        box2.setObj(String.valueOf(123));

        boxes.add(box);
        boxes.add(box2);


    }

    @Test
    public void usingPairs(){
        List list = new ArrayList();
        Pair<String, String> pl = new OrderPair<String,String>("akey","avalue");
        Pair<Integer, String> pl2 = new OrderPair<Integer,String>(123,"avalue");

    }

    @Test
    public void sumOfNumbers(List<? extends Number> numbers){

    }

}
