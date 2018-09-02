package lessons.reflection;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Reflector {
    public static void main(String[] args) {
       Class aClass = ForReflection.class;
      //  Class aClass = new ForReflection("", 5).getClass();

//        System.out.println(aClass.getSimpleName());

        int modifiers = aClass.getModifiers();

        //System.out.println(modifiers);

        if (!Modifier.isPublic(modifiers)) {
//            System.out.println("Default");
        }

        Class superclass = aClass.getSuperclass();

//        System.out.println(superclass.getSimpleName());

        Class[] interfaces = aClass.getInterfaces();

        for (Class anInterface : interfaces) {
//            System.out.println(anInterface.getSimpleName());
        }

        Field[] declaredFields = aClass.getDeclaredFields();

        for (Field field : declaredFields) {
            Class<?> type = field.getType();

            System.out.println("Name: " + field.getName() + "\t Type: " + type.getName());
        }

    }
}


class ForReflection implements Serializable, Cloneable {
    private String name;
    private int age;

    public ForReflection(String name, int age) {
        this.name = name;
        this.age = age;
    }


}
