package homeworks.HW.multithreading;

import java.io.IOException;

public class FactoryApp {
    public static void main(String[] args) throws IOException {
        User user = new User("Vasyl");
        user.order();
        user.checkState();
        user.cancelOrder("I can't wait");
    }
}

