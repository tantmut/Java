package homeworks.HW.addvertaisment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileService {

    public static final String ROOT_PATH =
            "/home/nazar/IdeaProjects/JavaProject/add_files_for_testing/";

    public FileService() throws IOException {
        Path path = Paths.get(ROOT_PATH);

        if(!Files.exists(path)){
            Files.createDirectory(Paths.get(ROOT_PATH));
        }
    }

    public void createFile(Map<String, String> file) throws IOException {

        Path path = Paths.get(ROOT_PATH);
        if(!Files.exists(path)){
            Files.createDirectory(Paths.get(ROOT_PATH));
        }
        Path pathToFile = Paths.get(ROOT_PATH + file);

        if (!Files.exists(pathToFile)) {
            Files.createFile(pathToFile);
            return;
        }
        System.out.println("File  with the same name is already exist");
    }

}