package homeworks.HW.addvertaisment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import static homeworks.HW.addvertaisment.FileService.ROOT_PATH;

public class AddService {

    private static final String PATH = "./add_files_for_testing/";
    public static final Path path = Paths.get(ROOT_PATH);

    private FileService fileService;


    AddService() throws IOException {
        fileService = new FileService();
        for (int i = 0; i <= 5; i++) {//IntStream
            createSite("os" + i, "browser" + i);
        }
    }

    public void createSite(String os, String browser) throws IOException {

        fileService.createFolder(os, browser);

        String path = PATH + os + "_" + browser;

        for (int i = 0; i < 5; i++) {//IntStream
            fileService.createFile("file" + i + ".txt", path);
        }

        fileService.createFile("conf", path);

        changeAdd("conf", path, os + "_" + browser);
    }

    public void deleteSite(String os, String browser) throws IOException {
        fileService.deleteFolder(os, browser);
    }

    public void addScreen(String screenName, String siteName) throws IOException {

        fileService.createFile(screenName, siteName);
    }

    public void changeAdd(String addName, String pathToScreen, String textOfAdd) throws IOException {

        try(FileWriter fw = new FileWriter(pathToScreen + "/" + addName, true)) {//should use Files class

            fw.write(textOfAdd);

        }
    }

    public void changeConf(String pathToScreen, String confName, String newConf) throws IOException {

        FileWriter fw = new FileWriter(pathToScreen + "/" + confName, false);//should use Files class

        fw.write(newConf);

        fw.close();

        File folder = new File(pathToScreen);

        File[] listOfFiles = folder.listFiles();

        /*DirectoryStream<Path> stream = Files.newDirectoryStream(null);

        stream.forEach();*/

        for (File file1 : listOfFiles) {

            if (file1.isFile() && !file1.toString().contains(confName)) {
                new FileWriter(file1).close();
            }
        }
    }
}
