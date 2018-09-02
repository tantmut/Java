package homeworks.HW.online_dating;

public class PersonService {
    private Person[] persons;

    public PersonService() {
        persons = new Person[10];//null
        Person lena = new Person("Lena", "Vasev", "Kiev", 2, 23, Sex.WOMAN);
        persons[0] = lena;
        persons[1] = new Person("Katya", "Vasev", "Kiev", 3, 23, Sex.WOMAN);
        persons[2] = new Person("Kolya", "Vasev", "Kiev", 3, 23, Sex.MAN);

    }

//    1) Регистрироваться человеку старше 18 лет.

    public boolean addPerson(Person man) {//man = person from Main class
//        resize
        boolean flag = false;
//        man.setName("Changed");

        if (man.getAge() < 18) {
            System.out.println("Your age must be more 18");
            return flag;
        }
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] == null) {
                persons[i] = man;
                flag = true;
                break;
            }
        }
        if (flag) {
            showSuitablePersons(man);
        }
        return flag;
    }
//2) После регистрации выводить список подходящих мужчин/ женщин(enum) для этого человека по возрасту.

    private void showSuitablePersons(Person man) {
        for (Person person : persons) {//Person person = persons[i]
            if (person != null && person.getSex() != man.getSex() && person.getAge() == man.getAge()) {
//                System.out.println(person);
            }
        }
    }
//3) Просматривать зарегистрировавшихся людей. Для мужчин выводить только женщин и наоборот.

    public void showClients(Sex sex) {//Sex.MAN
        for (Person man : persons) {
            if (man != null && man.getSex() != sex) {
                System.out.println(man);
            }
        }
    }

    //4) Просматривать анкету отдельного человека(поиск по имени и фамилии)
    public void findPersonByNameAndSurname(String name, String surname) {
        for (Person man : persons) {
            if (man != null && man.getName().equals(name) && man.getSurname().equals(surname)) {
                System.out.println(man);
            }
        }
    }
    //5) Организовать "умный поиск". Пользователь вводит требования(город, пол, возраст, количество детей) и  выводить людей,
    //которые соответствуют требованиям.
    public void smartSearch(String city, Sex sex, int age, int numberOfChildren) {
        for (Person man : persons) {
            if (man != null && man.getCity().equals(city) && man.getAge()==age && man.getSex().equals(sex) && man.getNumberOfChildren()==numberOfChildren ) {
                System.out.println(man);
            }
        }


    }
    //All people

    public void allPeople( ) {
        for (Person man : persons) {
            if( man != null){
                System.out.println(man);

            }

        }
    }
}
