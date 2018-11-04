package homeworks.HW.multithreading.products.bicycle;

import homeworks.HW.addvertaisment.FileService;
import homeworks.HW.file_manager.FileManager;
import homeworks.HW.multithreading.products.Product;
import homeworks.HW.multithreading.products.Stageable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static homeworks.HW.addvertaisment.AddService.getTextFile;
import static homeworks.HW.addvertaisment.FileService.writeToFile;

public class Bycicle extends Product {

    private List<Stageable> stages;
    private String workerName;

    public Bycicle() {

    }

    public Bycicle(String workerName) throws IOException {
        fileService = new FileService();
        stages = new ArrayList<>();
        cleanDir();
        fileService.createFile(workerName + ".txt", PATH);

        Frame frame = new Frame(workerName);
        frame.start();
        Wheels wheels = new Wheels(workerName);
        wheels.start();
        SteeringWheel steeringWheel = new SteeringWheel(workerName);
        Thread thread = new Thread(steeringWheel);
        thread.start();

        stages.add(wheels);
        stages.add(frame);
        stages.add(steeringWheel);

        this.workerName = workerName;
    }

    public List<Stageable> getStages() {
        return stages;
    }

    @Override
    public void cancelOrder(final String reason) throws IOException {
        writeToFile(reason, PATH, workerName);
    }

    public String checkState() {
        Path path = Paths.get(PATH, workerName + ".txt");
        return workerName + ": \n" + getTextFile(path);
    }

    private void cleanDir() throws IOException {
        Files.walkFileTree(Paths.get(PATH), new FileManager.DeleteVisitor());
    }
}
