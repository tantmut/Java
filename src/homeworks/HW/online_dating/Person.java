package homeworks.HW.online_dating;

public class Person {

    private String name;//null
    private String surname;
    private String city;
    private int numberOfChildren;//0
    private int age;//0
    private Sex sex;

    //controller -> service -> domain - Spring MVC
    //client -> dao -> domain - Hibernate



    public Person(String name, String surname, String city, int numberOfChildren, int age, Sex sex) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.numberOfChildren = numberOfChildren;
        this.age = age;
        this.sex = sex;
    }

    public Sex getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", city='" + city + '\'' +
                ", numberOfChildren=" + numberOfChildren +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
