package unit_test;

import com.itextpdf.text.DocumentException;
import homeworks.HW.file_manager.FileManager;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FileManager.class)
public class FileManagerTest {

    private static String fileName = "fileNazar";
    private static String pdfFile = "nazar.pdf";
    private static String folderName = "dirNazar";

    @Spy
    FileManager fileManager = new FileManager();

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    @Test
    public void shouldCreateFile() throws IOException {

        File file = folder.newFolder("com", "nazar", "luxoft");

        Path path = Paths.get(file.getAbsolutePath() + "/" + fileName);

        fileManager.createFile(path);

        Assert.assertTrue(Files.exists(path));
    }

    @Test
    public void shouldCreateDirectory() throws IOException {

        File file = folder.newFolder("com", "nazar", "luxoft");
        Path path = Paths.get(file.getAbsolutePath() + "/" + folderName);
        fileManager.createDirectory(path);

        Assert.assertTrue(Files.exists(path));
    }

    @Test
    public void shouldRemoveDir() throws IOException {

        File file = folder.newFolder("com", "nazar", "luxoft");
        Path path = Paths.get(file.getAbsolutePath() + "/" + folderName);

        List<String> files = Arrays.asList("first", "second", "third");

        fileManager.createDirectory(path);

        for (String fileName : files) {
            fileManager.createFile(path);
        }

        fileManager.removeDir(path);

        Assert.assertFalse(Files.exists(path));
    }

    @Test
    public void shouldRemoveFile() throws IOException {

        File file = folder.newFolder("com", "nazar", "luxoft");

        fileManager.createFile(file.toPath());

        fileManager.removeFile(file.toPath());

        Assert.assertFalse(Files.exists(file.toPath()));
    }

    @Test
    public void shouldRenameDir() throws IOException {

        File file = folder.newFolder("com", "nazar", "luxoft");
        String newDirName = "newDirName";

        Path pathToFolder = Paths.get(file.getAbsolutePath() + "/" + folderName);
        Path renamedPathToFolder = Paths.get(file.getAbsolutePath() + "/" + newDirName);

        fileManager.createDirectory(pathToFolder);
        fileManager.renameFileOrDir(pathToFolder, renamedPathToFolder);

        Assert.assertTrue(Files.exists(renamedPathToFolder));
        Assert.assertFalse(Files.exists(pathToFolder));

    }

    //
//    @Test
//    public void shouldCopyFile() throws IOException {
//
//        Path fileCopyPath = Paths.get(START + "//" + folderName + "//" + fileName);
//
//        fileManager.createFile(fileName);
//        fileManager.createDirectory(folderName);
//        fileManager.copyFile(fileName, folderName);
//
//        Assert.assertTrue(Files.exists(fileCopyPath));
//    }
//
    @Test
    public void shouldDisplayContentsDirectory() throws IOException {

        List<String> files = Arrays.asList("first", "second", "third");
        File file = folder.newFolder("com", "nazar", "luxoft");
        Path pathToCreatedFiles;

        for (String fileName : files) {
            pathToCreatedFiles = Paths.get(file.getAbsolutePath() + "/" + fileName);
            fileManager.createFile(pathToCreatedFiles);
        }

        fileManager.displayContentsDirectory(file.toPath());

        for (String fileName : files) {
            Assert.assertTrue(outRule.getLog().contains(fileName));
        }

    }

    @Test
    public void shouldConvertFromTxtToPdf() throws IOException, DocumentException {

        File file = folder.newFolder("com", "nazar", "luxoft");

        Path pathToTxtFile = Paths.get(file.getAbsolutePath() + "/" + fileName);
        Path pathToPDFFile = Paths.get(file.getAbsolutePath() + "/" + pdfFile);

        fileManager.createFile(pathToTxtFile);

        Files.write(pathToTxtFile, "the text".getBytes(), StandardOpenOption.APPEND);

        fileManager.convertFromTxtToPdf(file.getAbsolutePath(), pathToTxtFile, pdfFile);

        Assert.assertTrue(pathToPDFFile.toString().endsWith(".pdf"));
    }
}
