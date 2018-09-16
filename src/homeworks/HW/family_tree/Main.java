package homeworks.HW.family_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Person nazar = new Person("Nazar", "Yaremko", 27,
                0, true, Sex.MAN);

        FamillyService famillyService = new FamillyService();

        List<Person> nazarList = new ArrayList();
        Person galyna = new Person("Galyna", "Yaremko", 55,
                1, true, Sex.WOMAN);

        nazarList.add(galyna);

        Person orest = new Person("Orest", "Yaremko", 58,
                1, true, Sex.MAN);
        nazarList.add(orest);

        famillyService.addRelatives(nazar, nazarList);

        List<Person> galynaList = new ArrayList();

        Person maria = new Person("Maria", "Oprisk", 80,
                3, false, Sex.MAN);

        List<Person> mariaList = new ArrayList();

        Person maria1 = new Person("Maria", "Oprisk", 80,
                3, false, Sex.MAN);

        Person maria2 = new Person("Maria", "Oprisk", 80,
                3, false, Sex.MAN);

        mariaList.add(maria1);
        mariaList.add(maria2);

        galynaList.add(maria);


        galynaList.add(new Person("Bohdan", "Oprisk",80,
                3, false, Sex.MAN));

        famillyService.addRelatives(galyna, galynaList);


        List<Person> orestList = new ArrayList();
        orestList.add(new Person("Roman", "Yaremko",80,
                3, false, Sex.MAN));
        nazarList.add(orest);
        orestList.add(new Person("Myroslava", "Yaremko",70,
                3, false, Sex.WOMAN));
        Map<Person, List<Person>> orestRelatives = new HashMap<>();
        orestRelatives.put(galyna, orestList);

        Map<Person, List<Person>> nazarRelatives = new HashMap<>();
        nazarRelatives.put(new Person("Nazar", "Yaremko"), nazarList);

//        famillyService.printAllRelatives(nazar);
//        famillyService.printDirectRelatives(nazar);

//        List<Person> p = famillyService.getAllRelatives(nazar);

        System.out.println(famillyService.getRelationDegree(nazar,maria1));

    }
}
