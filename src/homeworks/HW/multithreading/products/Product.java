package homeworks.HW.multithreading.products;

import homeworks.HW.file_manager.FileManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static homeworks.HW.addvertaisment.FileService.writeToFile;
import static homeworks.HW.multithreading.products.Worker.workerName;

public class Product {

    private String name;
    private final String PATH = "./factory_files";
    private FileManager fileManager;
    public static Path path;
    private List<Stageable> stages;

    public Product(String name) throws IOException {
        fileManager = new FileManager();
        this.name = name;
        stages = new ArrayList<>();
        path = Paths.get(PATH + "/" + name + ".txt");
        fileManager.createFile(path);
    }

    public void addStageables(Stageable... stageable) {
        stages.addAll(Arrays.asList(stageable));

    }

    public List<Stageable> getStages() {
        return stages;
    }


    public void cancelOrder(String purpose) {
        try {
            writeToFile(Product.path, purpose);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String checkState() {

        List<String> list = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Product.path)) {
            list = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list.get(list.size()-1);
    }
}
