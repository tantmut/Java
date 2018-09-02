package lessons.overloading_overriding;

import lessons.overloading_overriding.another_package.AnimalOO;

public class CatOO extends AnimalOO {

    @Override
    public void print(String text) {
        getNumber();
        System.out.println(text);
    }

    @Override
    public Integer getNumber() {
        return 7;
    }
}
