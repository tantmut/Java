package lessons.learn_inheritance;

/**
 * Created by nazar on 3/11/2017.
 */
public abstract class Car implements Printable {
    private String model;


    /*{
        System.out.println("Non static block Car initialization");//6
    }

    static {
        System.out.println("Static block Car initialization");//5
    }*/

    public Car(String model) {
//        System.out.println("Constructor Car");//4
        this.model = model;
    }

    public abstract void getCount();
    /*@Override
    public void run() {
        System.out.println("Run");
    }

    @Override
    public void print() {
        System.out.println("Car");
    }*/

    /*public Car() {
    }*/

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
