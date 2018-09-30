package homeworks.HW.file_manager;

import java.io.*;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;
import java.util.List;

public class FileManager {

    public static final String ROOT_PATH = "./file_for_testing/";
    public static String file = "testing.txt";
    public static String folder = "New_Folder";
    public static Path pathToRootPath = Paths.get(ROOT_PATH);
    public static Path pathToCreatedFolder = Paths.get(ROOT_PATH + folder + "/testing.txt");
    public static Path pathToFile = Paths.get(ROOT_PATH + file);

    public void createDirectory(Path path) throws IOException {

        if (!Files.exists(path)) {
            Files.createDirectory(path);
            return;
        }
        System.out.println("Folder or file with the same name is already exist");

    }

    public void createFile(Path file) throws IOException {
        if (!Files.exists(file)) {
            Files.createFile(file);
            return;
        }
        System.out.println("File or folder with the same name is already exist");
    }

    public void copyFile(Path pathToFolder, Path pathToFile)
            throws IOException {
        //TODO: it's work incorectly
        Files.copy(pathToFolder, pathToFile, StandardCopyOption.REPLACE_EXISTING);
    }

    public void convertFromTxtToPdf(String pathToFolder, Path pathToTxt, String pdfFileName)
            throws IOException, DocumentException {

        StringBuilder builder = new StringBuilder();

        List<String> strings = Files.readAllLines(pathToTxt);

        if (!strings.isEmpty()) {
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream
                    (pathToFolder + "/" + pdfFileName));

            document.open();

            Iterator<String> iterator = strings.iterator();

            while (iterator.hasNext()) {
                builder.append(iterator.next()).append("\n");
            }

            Paragraph p = new Paragraph(builder.toString());

            p.setAlignment(Element.ALIGN_JUSTIFIED);

            document.add(p);

            document.close();

            return;
        }

        System.out.println("File is empty");

    }

    public void removeDir(Path path) throws IOException {

        if (Files.exists(path)) {
            Files.walkFileTree(path, new DeleteVisitor());
            return;
        }

        System.out.println("Folder does not exist");
    }

    public static class DeleteVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            return delete(path);
        }

        @Override
        public FileVisitResult postVisitDirectory(Path path, IOException e) throws IOException {
            return delete(path);
        }

        private FileVisitResult delete(Path path) throws IOException {
            Files.delete(path);
            return FileVisitResult.CONTINUE;
        }
    }

    public void removeFile(Path file) throws IOException {

        if (Files.exists(file)) {
            Files.delete(file);
            return;
        }

        System.out.println("File does not exist");

    }

    public void renameFileOrDir(Path oldPath, Path renamedPath) throws IOException {

        if (Files.exists(oldPath)) {
            Files.move(oldPath, renamedPath, StandardCopyOption.REPLACE_EXISTING);
            return;
        }

        System.out.println("File or Folder does not exist");
    }

    public void displayContentsDirectory(Path path) throws IOException {

        if (Files.exists(path)) {
            Files.list(path).forEach(System.out::println);
            return;
        }

        System.out.println("Folder does not exist");
    }

    public static void main(String[] args) throws IOException, DocumentException {
        FileManager fm = new FileManager();
//
//        fm.createDirectory(pathToCreatedFolder);
//        fm.createFile(pathToFile);
        fm.copyFile(pathToFile, pathToCreatedFolder);
//        fm.removeDir(pathToCreatedFolder);
//        fm.removeFile(pathToFile);
//        fm.renameFileOrDir(pathToFile, Paths.get(ROOT_PATH + "newName"));
        fm.displayContentsDirectory(pathToRootPath);
//        fm.convertFromTxtToPdf(ROOT_PATH, pathToFile, "nazar");
    }
}

