package homeworks.HW.multithreading.products;

import java.util.concurrent.TimeUnit;

public interface Stageable {
    void action();


    default void writeAction(String action) {
            //write the action to specific txt file

        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
