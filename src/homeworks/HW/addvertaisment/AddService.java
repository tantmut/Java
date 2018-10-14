package homeworks.HW.addvertaisment;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AddService {

    private static final String PATH = "./add_files_for_testing/";
    private final String CONF_FILE = "conf.txt";
    private FileService fileService;

    public static final Path path = Paths.get(PATH);

    AddService() throws IOException {
        fileService = new FileService();
        for (int i = 0; i <= 5; i++) {
            createSite("os" + i, "browser" + i);
        }
    }

    public void createSite(String os, String browser) throws IOException {

        fileService.createFolder(os, browser);

        String path = PATH + os + "_" + browser;

        for (int i = 0; i < 5; i++) {
            fileService.createFile("file" + i + ".txt", path);
        }

        fileService.createFile("conf.txt", path);

        changeAdd("conf.txt", path, os + "_" + browser);
    }

    public void deleteSite(String os, String browser) throws IOException {
        fileService.deleteFolder(os, browser);
    }

    public void addScreen(String screenName, String siteName) throws IOException {
        fileService.createFile(screenName, siteName);
    }

    public void changeAdd(String addName, String pathToScreen, String textOfAdd) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add(textOfAdd);
        Files.write(Paths.get(pathToScreen + "/" + addName), lines);
    }

    public void changeConf(String pathToScreen, String confName, String newConf) throws IOException {

        Path pathTofile = Paths.get(pathToScreen + "/" + confName);
        List<String> lines = Files.readAllLines(pathTofile);
        lines.add(newConf);
        Files.write(pathTofile, lines);
        deleteAllAddvertismentInScreen(pathToScreen, confName);
    }

    private void deleteAllAddvertismentInScreen(String pathToScreen, String confName)
            throws IOException {
        Path path = Paths.get(pathToScreen);
        Files.list(path)
                .forEach(file -> {
                    if (file.toFile().isFile() && !file.toString().contains(confName)) {
                        try {
                            Files.newInputStream(file, StandardOpenOption.CREATE_NEW);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void addNewAddvertisments(String os, String browser, String textOfAdd) throws IOException {

        Stream<Path> pathStream = Files.walk(Paths.get(PATH))
                .filter(file -> file.toString().contains(os + "_" + browser));

        List<String> lines = new ArrayList<>();
        lines.add(textOfAdd);
        pathStream.forEach(file -> {
            try {
                if(file.toFile().isFile() && !file.toString().contains(CONF_FILE))
                Files.write(file, lines);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
