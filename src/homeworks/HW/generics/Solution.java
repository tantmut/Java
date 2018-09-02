package homeworks.HW.generics;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Person> plot = new ArrayList<>();
        // plot.add(new Person("Репка", "Репку"));
        // plot.add(new Person("Дедка", "Дедку"));
        // plot.add(new Person("Бабка", "Бабку"));
        // plot.add(new Person("Внучка", "Внучку"));
        plot.add(new Person("Бабка", "Дедку"));
        plot.add(new Person("Дедка", "Репку"));
        plot.add(new Person("Внучка", "Бабку"));
        plot.add(new Person("Бабка", "Дедку"));
     }


    static class  Person  {

        String a = null;
        String b = null;

        Person(String a , String b){
            this.a = a;
            this.b = b;
        }

        public   void pull(Person person){

            System.out.println(person.a +" за " +person.b );

        }
    }
}
