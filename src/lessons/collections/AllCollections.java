package lessons.collections;

import java.util.*;

/*
* Methods of queue:
1) element(): This method retrieves the head of the queue.
2) offer(E o): This inserts the specified element into the queue.
3) peek(): This method retrieves the head of this queue,
returning null if this queue is empty.
4) poll(): This method retrieves and removes the head of this queue, or return null if this queue is empty.
5) remove(): This method retrieves and removes the head of this queue.
Note : From usability point of view add() and offer() do the same thing. Same goes for poll() and remove().
The difference between them is that the add method will throw an exception should the adding
of the item fail but the offer() method will simply return false.
The example also shows how to remove items from the queue by using any of the two methods for removing,
remove() and poll(). Like the methods to add items there’s one method that throws and exception if the
remove operation goes wrong (i.e. if the queue is empty) and one that only returns false.
*
* */

public class AllCollections {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(80);

        integers.add(5);
        integers.add(9);
        integers.add(7);
        integers = new LinkedList<>();

        integers.add(5);
        integers.add(9);
        integers.add(7);

//        System.out.println(integers);

        Set<Integer> set = new HashSet<>(integers);

        set.add(6);
        set.add(7);
        set.add(8);
        set.add(8);

        Set<String> strings = new LinkedHashSet<>();

        strings.add("Alive");
        strings.add("is");
        strings.add("Awesome");

        System.out.println(strings);

        integers = new ArrayList<>(set);

        for (int e : integers) {
//            System.out.println(e);
        }

        Iterator<Integer> iterator = integers.iterator();

       /* while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/

//        System.out.println(set);

        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return Integer.compare(person.getAge(), t1.getAge());
            }
        };

        Set<Person> treeSet = new TreeSet<>(comparator.reversed());

        treeSet.add(new Person("John", 20));
        treeSet.add(new Person("John1", 10));
        treeSet.add(new Person("John2", 5));

        System.out.println(treeSet);

    }



}



class Person implements Comparable {
    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Object o) {

        Person person = (Person) o;

        return Integer.compare(this.age, person.age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
