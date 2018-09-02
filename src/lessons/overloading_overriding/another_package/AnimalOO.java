package lessons.overloading_overriding.another_package;

import java.io.File;

public class AnimalOO {

    public void print(String text) {
        System.out.println(text);
    }

    protected Object getNumber() {
        return 2;
    }

    public File getNumber(Integer number) {
        return new File("");
//        return 2 + number;
    }
}

/*
* private
* default
* protected
* public
* */
