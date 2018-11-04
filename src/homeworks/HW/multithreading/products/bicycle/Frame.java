package homeworks.HW.multithreading.products.bicycle;

import homeworks.HW.multithreading.products.Stageable;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static homeworks.HW.addvertaisment.FileService.writeToFile;
import static homeworks.HW.multithreading.products.Product.PATH;


//public class Frame extends Thread implements Stageable {
//
//    public Frame(String workerName) throws IOException {
//        action(workerName);
//    }
//
//    @Override
//    public void action(final String workerName) throws IOException {
//        writeToFile("I have started development frame", PATH, workerName);
//
//        try {
//            TimeUnit.MILLISECONDS.sleep(2500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void run() {
//
//
//    }
//}
public class Frame extends Thread implements Stageable {

    private String workerName;

    public Frame(String workerName) throws IOException {
        this.workerName = workerName;
        run();
    }

    @Override
    public void action(final String workerName) throws IOException {
        writeToFile("I have started development frame", PATH, workerName);

        try {
            TimeUnit.MILLISECONDS.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try {
            writeToFile("I have started development frame", PATH, workerName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            TimeUnit.MILLISECONDS.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
