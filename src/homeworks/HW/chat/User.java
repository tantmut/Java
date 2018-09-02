package homeworks.HW.chat;

import java.util.Objects;

public class User {

    private String name;
    private String surname;
    private int age;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, surname, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname +
                "\', age=" + age +
                '}';
    }

}