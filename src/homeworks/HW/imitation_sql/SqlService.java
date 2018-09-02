package homeworks.HW.imitation_sql;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SqlService {

    public void selectAllFrom(List<? extends Object> list) {

        list.stream().forEach(System.out::println);
    }

    public void filterAndSortByMenNames(List<Man> men, int age) {

        men.stream()
                .filter(p -> p.getAge() > age)
                .sorted(Comparator.comparing(Man::getName))
                .forEach(Man::printWithoutAddress);
    }

    public void selectByNameLastNameStreet(List<Man> manList) {

        manList.stream()
                .filter(p -> {
                    int numberOfHome = p.getAddress().getNumberOfHome();

                    return p.getAddress().getCountry().equals("Canada") &&
                            (numberOfHome == 3 || numberOfHome >= 25);
                })
                .forEach(k -> k.printNameLastNameStreet());
    }

    public void updateManValues(List<Man> manList, String firstName, String lastName,
                                int countOfChildren, String country) {

        manList.stream()
                .filter(p -> p.getAddress().getCountry().equals(country))
                .forEach(f -> {
                    f.setName(firstName);
                    f.setSurname(lastName);
                    f.setAmountOfChildren(countOfChildren);
                });
    }

    //      Grouping
    public void groupByCountOfChildrenFromMan(List<Man> manList) {

        manList.stream()
                .collect(Collectors.groupingBy
                        (o -> o.getAmountOfChildren(), Collectors.counting()))
                .forEach((k, v) -> System.out.println("Amount of children: " + k +
                        "\tAmount of people: " + v));
    }

    public void groupByCountOfChildrenManAge(List<Man> manList) {

        manList.stream()
                .collect(Collectors.groupingBy(o -> o.getAge(), Collectors.groupingBy(
                        o -> o.getAmountOfChildren(), Collectors.counting()
                )))
                .forEach((k, v) -> System.out.println("Amount of age: " + k +
                        "\tAmount of children: " + v));
    }

    public void groupByCityStreetFromMan(List<Man> manList) {

        manList.stream()
                .collect(Collectors.groupingBy(o -> o.getAddress().getStreet(),
                        Collectors.groupingBy(o -> o.getAddress().getCity(),
                                Collectors.counting())))
                .forEach((k, v) -> System.out.println("Amount of street: " + k +
                        "\tAmount of city: " + v));
    }

    public void groupByCityStreetFromAddress(List<Address> addresses) {

        addresses.stream()
                .collect(Collectors.groupingBy(o -> o.getStreet(), Collectors.groupingBy(
                        o -> o.getCity(), Collectors.counting())))
                .forEach((k, v) -> System.out.println("Amount of street: " + k +
                        "\tAmount of city: " + v));
    }

    public void groupByCityAndStreetWithCondition(List<Address> addresses,
                                                     int amountOfCitizen) {

        addresses.stream()
                .filter(p -> p.getAmountOfPeople() > amountOfCitizen)
                .collect(Collectors.groupingBy(o -> o.getStreet(), Collectors.groupingBy(
                        o -> o.getCity(), Collectors.counting()
                )))
                .forEach((k, v) -> System.out.println("Amount of street: " + k +
                        "\tAmount of city: " + v));
    }

    public void groupByCityStreetFromManWithCond(List<Man> manList, int amountOfCitizen) {

        manList.stream()
                .filter(p -> p.getAddress().getAmountOfPeople() > amountOfCitizen)
                .collect(Collectors.groupingBy(o -> o.getAddress().getStreet(),
                        Collectors.groupingBy(
                                o -> o.getAddress().getCity(), Collectors.counting()
                        )))
                .forEach((k, v) -> System.out.println("Amount of street: " + k +
                        "\tAmount of city: " + v));
    }
}