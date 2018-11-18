package homeworks.HW.multithreading.products.bicycle;

import homeworks.HW.multithreading.products.Stageable;

import java.util.concurrent.TimeUnit;


public class Frame implements Stageable {

    public void action()   {
        writeAction("I have started development frame");

        try {
            TimeUnit.MILLISECONDS.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
