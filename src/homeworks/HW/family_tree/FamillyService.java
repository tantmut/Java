package homeworks.HW.family_tree;

import java.util.*;
import java.util.stream.Collectors;

public class FamillyService {

    private Map<Person, List<Person>> relatives;
    private List<Person> allRelatives;
    private int count;

    public FamillyService() {
        relatives = new HashMap<>();
        allRelatives = new ArrayList<>();
    }

    public void addRelatives(Person person, List<Person> people) {
        relatives.put(person, people);
    }

    public void printAllRelatives(Person person) {

        List<Person> people = relatives.get(person);

        System.out.println(person.getName() + " " + person.getSurName());

        if (Objects.isNull(people)) {
            return;
        }

        people.forEach(this::printAllRelatives);

    }

    public void printDirectRelatives(Person person) {

        List<Person> people = relatives.get(person);
        people.forEach(p -> System.out.println(p.getName() + " " + p.getSurName()));

    }


    private List<Person> getAllRelatives(Person person) {

        List<Person> people = relatives.get(person);

        allRelatives.add(person);

        if (Objects.isNull(people)) {
            return null;
        }

        people.forEach(this::getAllRelatives);

        return allRelatives;
    }

    public long getAmountOfAlived(Person nazar) {

        List<Person> getAllRelatives = getAllRelatives(nazar);

        return getAllRelatives.stream().filter(p -> p.isAlive() == true).count();

    }

    public int getAmountOfMan(Person nazar) {

        List<Person> getAllRelatives = getAllRelatives(nazar);

        return (int) getAllRelatives.stream().filter(p -> p.getSex() == Sex.MAN).count();

    }

    public int getAmountOfWoman(Person nazar) {

        List<Person> getAllRelatives = getAllRelatives(nazar);

        return (int) getAllRelatives.stream().filter(p -> p.getSex() == Sex.WOMAN).count();

    }

    public double getAverageChildren(Person nazar) {

        List<Person> getAllRelatives = getAllRelatives(nazar);

        double sumOfAllChildren = (double) getAllRelatives.stream()
                .collect(Collectors.summarizingInt(Person::getAmountOfChildren)).getSum();

        return sumOfAllChildren / getAllRelatives.size();

    }


    public double getAverageAge(Person nazar) {

        List<Person> getAllRelatives = getAllRelatives(nazar);

        double sumOfAllChildren = (double) getAllRelatives.stream()
                .collect(Collectors.summarizingInt(Person::getAge)).getSum();

        return sumOfAllChildren / getAllRelatives.size();

    }

    public int getRelationDegree(Person person, Person person1) {

        List<Person> people = relatives.get(person);

        if (people.contains(person1)) {
            return count;
        }

        count++;
        people.forEach(this::getAllRelatives);

        return count;
    }
}
