package lessons.collections.functional_interface.built_in_functional;


import homeworks.HW.online_dating.Person;
import homeworks.HW.online_dating.Sex;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TryBuiltIn {
    public static void main(String[] args) {
        Person person =
                new Person("John", "Find", "Lviv", 3, 25, Sex.MAN);

        Function<Person, Man> function = p -> new Man(p.getName(), p.getSurname());

//        System.out.println(function.apply(person));

        Consumer<Person> consumer = System.out::println;

//        consumer.accept(person);

        Supplier<Person> supplier = () -> person;

        System.out.println(supplier.get());
    }
}

