package homeworks.HW.multithreading.products.bicycle;

import homeworks.HW.multithreading.products.Stageable;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Wheels implements Stageable {

    @Override
    public void action()   {
        writeAction("I have started development wheels");

        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}