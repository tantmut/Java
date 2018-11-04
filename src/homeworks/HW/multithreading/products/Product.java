package homeworks.HW.multithreading.products;

import homeworks.HW.addvertaisment.FileService;

import java.io.IOException;

public abstract class Product {

    public final static String PATH = "./factory_files/";
    protected FileService fileService;

    public abstract void cancelOrder(final String reason) throws IOException;

    public abstract String checkState();
}
