package homeworks.HW.write_read.write;

import homeworks.HW.write_read.read.ReaderData;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class WriteData extends Writer {
    public static final Path PATH = Paths.get("./something/poem.txt");

    @Override
    public void write(String text) throws IOException {
        text = modifyText(text);
//        Files.write(ReaderData.PATH_TO_FILE, text.getBytes(), CREATE, APPEND);
        try (BufferedWriter writer = Files.newBufferedWriter(ReaderData.PATH)) {
            writer.write(text, 0, text.length());
        }
    }

/*public void write(String fileName, String text) {
        //Определяем файл
        File file = new File(fileName);

        try {
            //проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                file.createNewFile();
            }
            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Записываем текст у файл
                out.print(text);
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
}
