package homeworks.HW.family_tree;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Person {

    //    private String birthDate;
//    private String deathDate;
//    private String weddingDate;
//    private String job;
//    private String livingPlace;
//    private int amountOfChildren;
//    private int age;
//    private boolean alive;
    private String name;
    private String surName;
    private Sex sex;

    public Person() {

    }

    public Person(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public Sex getSex() {
        return sex;
    }

//    public Map<Person, List<Person>> getRelatives() {
//        return FamillyService.getRelatives();
//    }
//
//    private Map<Person, List<Person>> relatives;

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public Map<Person, List<Person>> getRelatives() {
        return FamillyService.getRelatives();
    }

    public void lineage() {
        FamillyService.lineage();
    }
}
//    Создать приложение родословная. Приложение должно позволять:
//        1) Выводить родословное дерево конкретного человека.
//        2) Показывать прямых родственников
//        3) Вычислять статистику по всему дереву:
// количество живых, мужчин/женщин, среднее количество детей, среднюю продолжительность жизни
//        4) Отображать в дереве место и даты рождения и свадьбы,
// место жительства, профессию и другую информацию о персоне;
//        5) Показывать прямых родственников с братьями и сёстрами, все родственники.
//        6) Показывать степень родства двух людей.


