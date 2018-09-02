package lessons.learn_inheritance.low_coupling_code;

/**
 * Created by nazar123 on 10.12.2017.
 */
public class Furniture {

    private Gun gun;
    private Fun fun;

    public Furniture(Gun gun, Fun fun) {
        this.gun = gun;
        this.fun = fun;
    }

    public void actionGun() {
        gun.print();
    }

    public void actionFun() {
        fun.print();
    }
}

class NewFurniture {

    private Drivable drivable;

    public NewFurniture(Drivable drivable) {
        this.drivable = drivable;
    }

    public void action() {
        drivable.print();
    }
}

interface Drivable {
    void print();
}

class Gun implements Drivable {
    public void print() {
        System.out.println("Gun");
    }
}

class Fun implements Drivable {
    public void print() {
        System.out.println("Fun");
    }
}


class TestLow {
    public static void main(String[] args) {
        Drivable gun = new Gun();

        Drivable fun = new Fun();

        NewFurniture furniture = new NewFurniture(fun);

    }
}
