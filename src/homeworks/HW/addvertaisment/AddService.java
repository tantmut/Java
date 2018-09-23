package homeworks.HW.addvertaisment;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

import static homeworks.HW.addvertaisment.FileService.ROOT_PATH;

public class AddService {

    private Map<Map<String,String>, String> osAndBrowsers;
    private FileService fileService;
    public static final Path path = Paths.get( ROOT_PATH);

    AddService() throws IOException {
        this.osAndBrowsers = new HashMap<>();
        Map<String, String> screen1 = new HashMap< >();
        Map<String, String> screen2 = new HashMap<>();
        Map<String, String> screen3 = new HashMap<>();
        screen1.put("Windows8", "Opera");
        screen2.put("Windows9", "Chrome");
        screen3.put("Mac", "Safari");

        osAndBrowsers.put(screen1,"");
        osAndBrowsers.put(screen2,"");
        osAndBrowsers.put(screen3,"");

        fileService = new FileService();

        osAndBrowsers.keySet().forEach(k-> {
            try {
                fileService.createFile(k);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

     }

    public  Map<Map<String,String>, String> getOsAndBrowsers() {
        return osAndBrowsers;
    }

    public void setOsAndBrowsers( Map<Map<String,String>, String> osAndBrowsers) {
        this.osAndBrowsers = osAndBrowsers;
    }

    public void createAdd(String os, String browser, String newADD) {

        Map<String, String> screen = new HashMap<>();
        screen.put(os, browser);

        osAndBrowsers.put(screen,newADD);
    }

    public void createNewScreen(String os, String browser) throws IOException {

        HashMap<String, String> screen = new HashMap<>();
        screen.put(os, browser);

        osAndBrowsers.put(screen, "");
        fileService.createFile(screen);

    }

    public void deleteAdd(String os, String browser) {
        Map<String, String> screen = new HashMap<>();
        screen.put(os, browser);

        osAndBrowsers.remove(screen);

    }

    public void syncData() throws IOException {

        for (Map<String, String> screen : osAndBrowsers.keySet()) {

            Path path = Paths.get( ROOT_PATH + screen);

            FileChannel.open(path, StandardOpenOption.WRITE).truncate(0).close();

            BufferedWriter writer = Files.newBufferedWriter(path);

            writer.append(osAndBrowsers.get(screen));

        }
    }
}
