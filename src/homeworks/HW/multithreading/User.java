package homeworks.HW.multithreading;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static homeworks.HW.addvertaisment.AddService.getTextFile;
import static homeworks.HW.multithreading.Factory.PATH;
import static homeworks.HW.multithreading.Factory.writeToFile;

public class User {

    private Factory worker;
    private String workerName;

    public User(String workerName) throws IOException {
        worker = new Factory(workerName);
    }

    public void order() throws IOException {
        worker.createBicycle(workerName);
    }

    public String checkState() {
        Path path = Paths.get(PATH, workerName + ".txt");
        return getTextFile(path);
    }

    public void cancelOrder(final String reason) throws IOException {
        writeToFile(reason, workerName);
    }
}
