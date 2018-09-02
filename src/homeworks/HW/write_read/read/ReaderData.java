package homeworks.HW.write_read.read;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by nazar on 4/16/2017.
 */
public class ReaderData {
    public static final Path PATH = Paths.get("./something/poem.txt");

    public void readLog() throws IOException {
        /*
        StringBuffer buffer = new StringBuffer();

        try (BufferedReader reader = Files.newBufferedReader(PATH)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        }

        System.out.println( buffer.toString()) ;
        */
        Files.lines(PATH, StandardCharsets.UTF_8).forEach(System.out::println);

        List<String> strings = Files.readAllLines(PATH);

    }
}
