package homeworks.HW.addvertaisment;

import homeworks.HW.file_manager.FileManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    public static final String ROOT_PATH = "./add_files_for_testing/";

    public FileService() throws IOException {
        Path path = Paths.get(ROOT_PATH);

        if (!Files.exists(path)) {
            Files.createDirectory(Paths.get(ROOT_PATH));
        }
    }

    public void createFile(String file, String dir) throws IOException {

        Path path = Paths.get(dir);

        if (!Files.exists(path)) {
            Files.createDirectory(Paths.get(dir));
        }

        Path pathToFile = Paths.get(dir + "/" + file);

        if (!Files.exists(pathToFile)) {
            Files.createFile(pathToFile);
            return;
        }

        System.out.println("File  with the same name is already exist");
    }


    public void createFolder(String name, String name1) throws IOException {

        Path path = Paths.get(ROOT_PATH);
        if (!Files.exists(path)) {
            Files.createDirectory(Paths.get(ROOT_PATH));
        }
        Path pathToDir = Paths.get(ROOT_PATH + name + "_" + name1);

        if (!Files.exists(pathToDir)) {
            Files.createDirectory(pathToDir);
            return;
        }
        System.out.println("Dir  with the same name is already exist");
    }

    public void deleteFolder(String linux, String chrome) throws IOException {
        Path path = Paths.get(ROOT_PATH + linux + "_" + chrome);

        if (Files.exists(path)) {
            Files.walkFileTree(path, new FileManager.DeleteVisitor());
            return;
        }

    }
}