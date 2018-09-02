package lessons.learn_inheritance;

/**
 * Created by nazar on 3/11/2017.
 */
public interface Printable extends Cloneable, Runnable {
    public static final int COUNT = 5;

    //    final int count = 5;
 /*   public abstract void print();
    abstract void print();*/
    void print();


    default int getNumber() {
        return 5;
    }

 }

