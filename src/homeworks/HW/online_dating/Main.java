package homeworks.HW.online_dating;

/**
 * Created by nazar on 3/18/2017.
 */
public class Main {

    public static void main(String[] args) {
        PersonService service = new PersonService();

        Person person = new Person("Vasya", "Vasev", "Kiev", 2, 23, Sex.MAN);
        Person man = person;

        boolean result = service.addPerson(person);
//        service.showClients(Sex.MAN);
//        service.showClients(person.getSex());
        //service.findPersonByNameAndSurname("Lena", "Vasev");
        service.allPeople();
//        System.out.println(result);
//        System.out.println(person.getName());
    }
}


