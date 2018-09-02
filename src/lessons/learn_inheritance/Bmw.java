package lessons.learn_inheritance;

/**
 * Created by nazar on 3/11/2017.
 */
//public class Bmw extends Car implements Printable {
//public class Bmw extends Car implements Printable, Cloneable {
public class Bmw extends Car implements Cloneable {

    private String type;

    /*{
        System.out.println("Non static block Bmw initialization");//3
    }

    static {
        System.out.println("Static block Bmw initialization");//2
    }*/

    public Bmw(String model, String type) {
        super(model);
//        System.out.println("Constructor Bmw");//1
        this.type = type;
    }

    @Override
    public void print() {

    }

    @Override
    public void getCount() {

    }

    @Override
    public void run() {

    }



    /*@Override
    public void run() {
        System.out.println("Run");
    }*/
/*
    @Override
    public void print() {
        int number = getNumber();
        System.out.println("BMw print" + COUNT);
    }*/

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Bmw{" +
                "type='" + type + '\'' +
                '}';
    }
}
// 3 2 1 6 5 4
