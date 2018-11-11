package homeworks.HW.multithreading;

import homeworks.HW.multithreading.products.Product;
import homeworks.HW.multithreading.products.Stageable;
import homeworks.HW.multithreading.products.Worker;
import homeworks.HW.multithreading.products.bicycle.Frame;
import homeworks.HW.multithreading.products.bicycle.SteeringWheel;
import homeworks.HW.multithreading.products.bicycle.Wheels;

import java.io.IOException;

public class FactoryApp {
    public static void main(String[] args) throws IOException {

        Product bicycle = new Product("Bycicle");

        Stageable frame = new Frame();

        Stageable stwheel = new SteeringWheel();

        Stageable wheels = new Wheels();

        bicycle.addStageables(frame, stwheel, wheels);

        Worker nazar = new Worker(bicycle, "Nazar");


    }
}

