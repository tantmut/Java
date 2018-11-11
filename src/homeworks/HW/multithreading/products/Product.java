package homeworks.HW.multithreading.products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product {

    private String name;

    private List<Stageable> stages;

    public Product(String name) {
        this.name = name;
        stages = new ArrayList<>();
    }

    public void addStageables(Stageable... stageable) {
        stages.addAll(Arrays.asList(stageable));
    }

    public List<Stageable> getStages() {
        return stages;
    }
}
