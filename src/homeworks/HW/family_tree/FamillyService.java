package homeworks.HW.family_tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FamillyService {

    private Map<Person, List<Person>> relatives;

    public FamillyService() {
        this.relatives = new HashMap<>();
    }

    public void addRelatives(Person person, List<Person> people) {
        relatives.put(person, people);
    }

    public void lineage(Person person) {

        List<Person> people = relatives.get(person);

        System.out.println(person.getName() + " " + person.getSurName());

        if (Objects.isNull(people)) {
            return;
        }

        people.forEach(this::lineage);

    }
}
