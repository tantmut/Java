package homeworks.HW.family_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Person nazar = new Person("Nazar", "Yaremko");

        FamillyService famillyService = new FamillyService();

        List<Person> nazarList = new ArrayList();
        Person galyna = new Person("Galyna", "Yaremko");

        nazarList.add(galyna);

        Person orest = new Person("Orest", "Yaremko");

        nazarList.add(orest);

        famillyService.addRelatives(nazar, nazarList);

        List<Person> galynaList = new ArrayList();

        galynaList.add(new Person("Maria", "Oprisk"));

        galynaList.add(new Person("Bohdan", "Oprisk"));

        famillyService.addRelatives(galyna, galynaList);


        List<Person> orestList = new ArrayList();
        orestList.add(new Person("Roman", "Yaremko"));
        orestList.add(new Person("Myroslava", "Yaremko"));
        Map<Person, List<Person>> orestRelatives = new HashMap<>();
        orestRelatives.put(galyna, orestList);

        Map<Person, List<Person>> nazarRelatives = new HashMap<>();
        nazarRelatives.put(new Person("Nazar", "Yaremko"), nazarList);


        famillyService.lineage(nazar);

    }
}
