package homeworks.HW.addvertaisment;

import java.io.IOException;

import static homeworks.HW.addvertaisment.FileService.ROOT_PATH;

public class Main {
    public static void main(String[] args) throws IOException {

        AddService add = new AddService();

        add.createSite("Linux", "Chrome");
        add.addScreen("addvertisment", ROOT_PATH + "Linux_Chrome");
        add.changeAdd("file1", ROOT_PATH + "Linux_Chrome", "something new");
        add.changeConf(ROOT_PATH + "Linux_Chrome", "conf", "Windows_Chrome");
    }
}
