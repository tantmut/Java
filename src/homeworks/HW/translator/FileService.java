package homeworks.HW.translator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    public static final String ROOT_PATH =
            "/home/nazar/IdeaProjects/JavaProject/file_for_testing/";

    public void createFile(String file) throws IOException {

        Path pathToFile = Paths.get(ROOT_PATH + file);
        if (!Files.exists(pathToFile)) {
            Files.createFile(pathToFile);
            return;
        }
        System.out.println("File  with the same name is already exist");
    }
}
