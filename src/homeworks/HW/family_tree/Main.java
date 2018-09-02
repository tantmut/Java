package homeworks.HW.family_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        List<Person> nazarList = new ArrayList();
        nazarList.add(new Person("Galyna", "Yaremko"));
        nazarList.add(new Person("Orest", "Yaremko"));

        List<Person> galynaList = new ArrayList();
        galynaList.add(new Person("Maria", "Oprisk"));
        galynaList.add(new Person("Bohdan", "Oprisk"));
        Map<Person, List<Person>> galynaRelatives = new HashMap<>();
        galynaRelatives.put(new Person("Galyna", "Yaremko"), galynaList);

        List<Person> orestList = new ArrayList();
        orestList.add(new Person("Roman", "Yaremko"));
        orestList.add(new Person("Myroslava", "Yaremko"));
        Map<Person, List<Person>> orestRelatives = new HashMap<>();
        orestRelatives.put(new Person("Galyna", "Yaremko"), orestList);

        Map<Person, List<Person>> nazarRelatives = new HashMap<>();
        nazarRelatives.put(new Person("Nazar", "Yaremko"), nazarList);


        Person nazar = new Person("Nazar", "Yaremko");

        FamillyService famillyService = new FamillyService(nazar, nazarRelatives);

        famillyService.lineage();

    }
}
