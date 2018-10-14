package homeworks.HW.addvertaisment;

import java.io.IOException;

import static homeworks.HW.addvertaisment.FileService.ROOT_PATH;

public class Main {
    public static void main(String[] args) throws IOException {

        AddService add = new AddService();

        add.createSite("Linux", "Chrome");

        add.addScreen("addvertisment.txt", ROOT_PATH + "Linux_Chrome");
        add.changeAdd("file1.txt", ROOT_PATH + "Linux_Chrome",
                "something new");
        add.changeConf(ROOT_PATH + "Linux_Chrome", "conf.txt",
                "Windows_Chrome");

        add.addNewAddvertisments("Linux","Chrome"," new Addvertisment");
    }
}
