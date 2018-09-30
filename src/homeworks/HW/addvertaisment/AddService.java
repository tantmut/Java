package homeworks.HW.addvertaisment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import static homeworks.HW.addvertaisment.FileService.ROOT_PATH;

public class AddService {

    private static final String PATH = "/home/nazar/IdeaProjects/JavaProject/add_files_for_testing/";

    private FileService fileService;
    public static final Path path = Paths.get(ROOT_PATH);

    AddService() throws IOException {
        fileService = new FileService();
    }


    public void createSite(String linux, String chrome) throws IOException {

        fileService.createFolder(linux, chrome);
        String newpath = PATH + linux + "_" + chrome;
        for (int i = 0; i <= 4; i++) {
            fileService.createFile("file" + i, newpath);
        }

        fileService.createFile("conf", newpath);
        changeAdd("conf", newpath, linux + "_" + chrome);


    }

    public void deleteSite(String linux, String chrome) throws IOException {
        fileService.deleteFolder(linux, chrome);

    }

    public void addScreen(String addvertisment, String siteName) throws IOException {

        fileService.createFile(addvertisment, siteName);
    }

    public void changeAdd(String file1, String s, String something_new) throws IOException {


        FileWriter fw = new FileWriter(s + "/" + file1, true); //the true will append the new data
        fw.write(something_new);//appends the string to the file
        fw.close();
    }

    public void changeConf(String s, String file, String windows_chrome) throws IOException {

        FileWriter fw = new FileWriter(s + "/" + file, false); //the true will append the new data
        fw.write(windows_chrome);//appends the string to the file
        fw.close();
        File folder = new File(s);

        File[] listOfFiles = folder.listFiles();


        for (File file1 : listOfFiles) {

            if (file1.isFile() && !file1.toString().contains(file)) {
                new FileWriter(file1).close();
            }
        }


    }
}
