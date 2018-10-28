package homeworks.HW.multithreading;

import homeworks.HW.addvertaisment.FileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Factory {

    protected static final String PATH = "./factory_files/";
    protected String workerName;
    private FileService fileService;

    public Factory(String workerName) throws IOException {
        fileService = new FileService();
        this.workerName = workerName;
        fileService.createFile(workerName + ".txt", PATH);
    }

    public void createBicycle(final String workerName) throws IOException {
        createFrame(workerName);
        createWheels(workerName);
        createSteeringWheel(workerName);
        createOtherDetails(workerName);
    }

    private void createSteeringWheel(final String workerName) throws IOException {
        writeToFile("I have started development steering wheel", workerName);
        try {
            Thread.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void createOtherDetails(final String workerName) throws IOException {
        writeToFile("I have started development other details", workerName);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void createWheels(final String workerName) throws IOException {
        writeToFile("I have started development wheels", workerName);

        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createFrame(final String workerName) throws IOException {
        writeToFile("I have started development frame", workerName);

        try {
            TimeUnit.MILLISECONDS.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(final String s, final String workerName) throws IOException {
        Files.write(Paths.get(PATH, workerName + ".txt"), Arrays.asList(s),
                StandardOpenOption.APPEND);
    }
}
