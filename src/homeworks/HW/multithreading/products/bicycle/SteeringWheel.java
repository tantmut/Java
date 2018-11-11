package homeworks.HW.multithreading.products.bicycle;

import homeworks.HW.multithreading.products.Stageable;

import java.util.concurrent.TimeUnit;


public class SteeringWheel implements Stageable {

    @Override
    public void action() {
        writeAction("Install steering wheel");

        try {
            TimeUnit.MILLISECONDS.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
