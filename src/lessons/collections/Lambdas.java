package lessons.collections;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambdas {
    public static void main(String[] args) {
        List<Man> men = Arrays.asList(
                new Man("First", 24),
                new Man("Second", 17),
                new Man("Third", 18));

        Predicate<Man> predicate = man -> man.getAge() < 24;


        getFilteredMen(predicate);
        getFilteredMen(man -> man.getAge() < 24);

        List<Man> collect = men.stream()
                .filter(predicate)
                .collect(Collectors.toList());

//        System.out.println(collect);

        List<Child> children =
                men.stream()
                        .map(man -> new Child(man.getName(), man.getAge()))
                        .collect(Collectors.toList());

//        System.out.println(men.stream().allMatch(man -> man.getAge() > 18));
//        System.out.println(men.stream().anyMatch(man -> man.getAge() > 18));

        Map<Integer, List<Man>> map = men.stream().collect(Collectors.groupingBy(p -> p.getAge() % 2));

//        System.out.println(map);

        Integer sum = men.stream().collect(Collectors.summingInt(Man::getAge));

//        Integer sum = men.stream().mapToInt(Man::getAge).sum();

//        System.out.println(sum);

        Comparator<Man> comparator = new Comparator<Man>() {
            @Override
            public int compare(Man man, Man t1) {
                return man.getAge() - t1.getAge();
            }
        };

//        Comparator<Man> manComparator = (m1, m2) -> Integer.compare(m1.getAge(), m2.getAge());
        Comparator<Man> manComparator = Comparator.comparingInt(Man::getAge);

//        Collections.sort(men, comparator.reversed());

        List<Man> men1 = men.stream().sorted().collect(Collectors.toList());

        System.out.println(men);
    }

    public static List<Man> getFilteredMen(Predicate<Man> predicate) {
        List<Man> men = Arrays.asList(
                new Man("First", 24),
                new Man("Second", 17),
                new Man("Third", 18));
        return men.stream().filter(predicate).collect(Collectors.toList());
    }
}

class Man implements Comparable<Man> {
    private String name;
    private int age;

    public Man(String name, int age) {
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
    public int compareTo(Man man) {
        return -this.getAge() + man.getAge();
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Child extends Man {
    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Child{}";
    }
}
