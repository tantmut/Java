package homeworks.HW.addvertaisment;

import homeworks.HW.file_manager.FileManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class FileService {

    public static final String ROOT_PATH = "./add_files_for_testing/";
    private static final Path PATH = Paths.get(ROOT_PATH);


    public FileService() throws IOException {

        if (!Files.exists(PATH)) {
            Files.createDirectory(PATH);
        }
    }

    public void createFile(String file, String dir) throws IOException {

        Path path = Paths.get(dir);

        if (!Files.exists(path)) {
            Files.createDirectory(path);
        }

        Path pathToFile = Paths.get(dir, file);

        if (!Files.exists(pathToFile)) {
            Files.createFile(pathToFile);
            return;
        }

        System.out.println("File  with the same name is already exist");
    }

    public static void writeToFile(final String s, final String path, final String workerName)
            throws IOException {
        Files.write(Paths.get(path, workerName + ".txt"), Arrays.asList(s),
                StandardOpenOption.APPEND);
    }

    public void createFolder(String siteName) throws IOException {

        Path path = Paths.get(ROOT_PATH);

        if (!Files.exists(path)) {
            Files.createDirectory(path);
        }

        Path pathToDir = Paths.get(ROOT_PATH, siteName);

        if (!Files.exists(pathToDir)) {
            Files.createDirectory(pathToDir);
            return;
        }

        System.out.println("Dir with the same name is already exist");
    }

    public void deleteFolder(String linux, String chrome) throws IOException {
        Path path = Paths.get(ROOT_PATH + linux + "_" + chrome);

        if (Files.exists(path)) {
            Files.walkFileTree(path, new FileManager.DeleteVisitor());
            return;
        }

    }
}