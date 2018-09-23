package homeworks.HW.addvertaisment;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        AddService add = new AddService();

//        add.createAdd("Mac", "Safari", "NewADD");
        add.createNewScreen("Linux", "Chrome");
//        add.deleteAdd("Linux", "Chrome");
        add.createAdd("Linux", "Chrome","NewADD");

        add.syncData();
    }
}
