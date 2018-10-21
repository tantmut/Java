package homeworks.HW.addvertaisment;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class AddService {

    private static final String PATH = "./add_files_for_testing/";
    private final String CONF_FILE = "conf.txt";
    private FileService fileService;

    public static final Path path = Paths.get(PATH);

    AddService() throws IOException {
        fileService = new FileService();

        IntStream.rangeClosed(0, 5).forEach(i -> {
            try {
                createSite("siteName" + i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void createSite(String siteName) throws IOException {

        fileService.createFolder(siteName);

        String path = PATH + siteName;

        for (int i = 0; i < 5; i++) {
            fileService.createFile("file" + i + ".txt", path);
        }

        fileService.createFile("conf.txt", path);
    }

    public void deleteSite(String os, String browser) throws IOException {
        fileService.deleteFolder(os, browser);
    }

    public void addScreen(String screenName, String path) throws IOException {
        fileService.createFile(screenName, path);
    }

    public void changeAdd(String addName, String pathToScreen, String textOfAdd) throws IOException {
        Files.write(Paths.get(pathToScreen, addName), Arrays.asList(textOfAdd));
    }

    public void changeConf(String pathToSite, String confName, String newConf) throws IOException {

        Path pathToConf = Paths.get(pathToSite, confName);

        Files.write(pathToConf, Arrays.asList(newConf));

        deleteAllAddvertismentInScreen(pathToSite, confName);
    }

    private void deleteAllAddvertismentInScreen(String pathToScreen, String confName)
            throws IOException {
        Path path = Paths.get(pathToScreen);
        Files.list(path)
                .forEach(file -> {
                    if (!Files.isDirectory(file) && !file.toString().contains(confName)) {
                        try {
                            Files.write(file, "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void addNewAddvertisments(String os, String browser, String textOfAdd) throws IOException {

        Files.walk(Paths.get(PATH))
                .filter(file -> file.toString().contains("conf.txt")
                        && getStringOfFile(file).contains(os + "_" + browser))
                .map(f -> f.getParent())
                .forEach(f -> {
                    try {
                        Files.walk(f)
                                .forEach(file -> {
                                    try {
                                        if (!file.toString().contains(CONF_FILE))
                                            Files.write(file, Arrays.asList(textOfAdd));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    private String getStringOfFile(Path file) {
        String s = null;
        try {
            s = new String(Files.readAllBytes(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}
