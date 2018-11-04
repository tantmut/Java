package homeworks.HW.multithreading;

import homeworks.HW.multithreading.products.Product;
import homeworks.HW.multithreading.products.bicycle.Bycicle;

import java.io.IOException;

public class FactoryApp {
    public static void main(String[] args) throws IOException {


        Product bicycle = new Bycicle("nazar");

        System.out.println(bicycle.checkState());

        bicycle.cancelOrder("You are crazy");
    }
}

