package homeworks.HW.family_tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FamillyService {

    private static Person person;
    private static Map<Person, List<Person>> relatives;

    public FamillyService(Person person, Map<Person, List<Person>> relatives) {
        this.person = person;
        this.relatives = relatives;
    }

    public static Map<Person, List<Person>> getRelatives() {
        return relatives;
    }

    public static void lineage() {

        if (Objects.isNull(person.getRelatives())) {
            return;
        }

        System.out.println(person.getName() + " " + person.getSurName());

        person.getRelatives().forEach(
                (key, val) -> val.stream().forEach((k) -> k.lineage()));

    }
}
