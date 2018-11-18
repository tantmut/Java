package homeworks.HW.multithreading.products;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static homeworks.HW.addvertaisment.FileService.writeToFile;
import static homeworks.HW.multithreading.products.Worker.workerName;

public interface Stageable {

    void action();

    default void writeAction(String action) {
        try {
            writeToFile(Product.path, "Worker " + workerName + " "+action);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
