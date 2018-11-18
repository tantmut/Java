package homeworks.HW.multithreading.products;

import java.io.IOException;

public class Worker implements Runnable {

    private Product product;
    public static String workerName;

    public Worker(Product product, String name) {
        this.product = product;
        this.workerName = name;

        new Thread(this, name).start();
    }

    @Override
    public void run() {
        product.getStages().forEach(Stageable::action);
    }
}
