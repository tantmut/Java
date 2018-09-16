package homeworks.HW.family_tree;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Person {


    private int amountOfChildren;
    private int age;
    private boolean alive;

    public int getAmountOfChildren() {
        return amountOfChildren;
    }

    public void setAmountOfChildren(int amountOfChildren) {
        this.amountOfChildren = amountOfChildren;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    private String name;
    private String surName;
    private Sex sex;

    public Person() {

    }

    public Person(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public Person(String name, String surName, int age, int amountOfChildren, boolean alive, Sex sex) {
        this.name = name;
        this.surName = surName;
        this.amountOfChildren = amountOfChildren;
        this.age = age;
        this.alive = alive;
        this.sex = sex;

    }

    public Sex getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surName, person.surName) &&
                sex == person.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, sex);
    }

}

