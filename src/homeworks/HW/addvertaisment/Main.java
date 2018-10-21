package homeworks.HW.addvertaisment;

import java.io.IOException;

import static homeworks.HW.addvertaisment.FileService.ROOT_PATH;

public class Main {
    public static void main(String[] args) throws IOException {

        AddService add = new AddService();

        add.createSite("Linux" );

        add.addScreen("addvertisment.txt", ROOT_PATH + "Linux");
        add.changeAdd("file1.txt", ROOT_PATH + "Linux",
                "something new");
        add.changeConf(ROOT_PATH + "Linux", "conf.txt",
                "Windows_Chrome");
        add.changeConf(ROOT_PATH + "siteName1", "conf.txt",
                "Windows_Chrome");

        add.addNewAddvertisments("Windows","Chrome"," new Addvertisment");
    }
}
