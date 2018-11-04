package homeworks.HW.multithreading.products.bicycle;

import homeworks.HW.multithreading.products.Stageable;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static homeworks.HW.addvertaisment.FileService.writeToFile;
import static homeworks.HW.multithreading.products.Product.PATH;

public class Wheels extends Thread implements Stageable {

//    public Wheels(String workerName) throws IOException {
//         action(workerName);
//    }
//
//    @Override
//    public void action(final String workerName) throws IOException {
//        writeToFile("I have started development wheels", PATH, workerName);
//
//        try {
//            TimeUnit.MILLISECONDS.sleep(1500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//
//        }
//    }

    private String workname;

    public Wheels(String workerName) throws IOException {
        this.workname = workerName;
        run();
    }

    @Override
    public void run(){
        try {
            writeToFile("I have started development wheels", PATH, workname);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void action(final String workerName) throws IOException {
        writeToFile("I have started development wheels", PATH, workerName);

        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}