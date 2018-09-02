package homeworks.HW.imitation_sql;

public class Man implements Comparable<Man> {

    private String name;
    private String surname;
    private int age;
    private int amountOfChildren;
    private Address address;

    public Man(String name, String surname, int age, int amountOfChildren, Address address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.amountOfChildren = amountOfChildren;
        this.address = address;
    }

    public int getAmountOfChildren() {
        return amountOfChildren;
    }

    public int getAge() {
        return age;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
     }

    public void setAmountOfChildren(int amountOfChildren) {
        this.amountOfChildren = amountOfChildren;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", amountOfChildren=" + amountOfChildren +
                ", address=" + address +
                '}';
    }

    @Override
    public int compareTo(Man ob) {
        return name.compareTo(ob.getName());
    }

    public void printWithoutAddress() {

        System.out.println("Man{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", amountOfChildren=" + amountOfChildren +
                '}');
    }

    public void printNameLastNameStreet() {

        System.out.println("Man{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", street='" + getAddress().getStreet() +
                '}');
    }

}
