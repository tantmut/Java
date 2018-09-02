package homeworks.HW.translator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LanguageService {

    private FileService fileService;

    public static final Path path = Paths.get(FileService.ROOT_PATH);

    private Map<String, Map<String, String>> langCollection;

    public LanguageService() {

        langCollection = new HashMap<>();

        fileService = new FileService();

        putAllDataFromFilesToMap();

    }

    public void putAllDataFromFilesToMap() {

        Map<String, String> mapFromFile;

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path path : stream) {
                mapFromFile = Files.lines
                        (Paths.get(FileService.ROOT_PATH + path.getFileName()))
                        .filter(s -> s.matches("\\w+:\\w+"))
                        .collect(Collectors.toMap(k -> k.split(":")[0],
                                v -> v.split(":")[1]));
                langCollection.put(path.toFile().getName(), mapFromFile);
            }
        } catch (IOException | DirectoryIteratorException x) {

            x.printStackTrace();
        }

    }

    public void addNewPairOfWords(final String language, final String originWord,
                                  final String translatedWord) {

        langCollection.get(language).put(originWord, translatedWord);

    }

    public void addNewPairLanguages(final String language) {

        String[] split = language.split("_");

        String reverseLanguage = split[1] + "_" + split[0];

        Map<String, String> emptyMap = new HashMap<>();

        try {

            if (Objects.nonNull(langCollection.get(language))) {

                System.out.println("This languages are already exist");

                return;
            }

            fileService.createFile(language);

            fileService.createFile(reverseLanguage);

            langCollection.put(language, emptyMap);
            langCollection.put(reverseLanguage, emptyMap);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void printListOfLanguages() {

        langCollection.forEach((key, value) -> System.out.println(key));

        langCollection.keySet().forEach(System.out::println);

    }

    public void printListOfWordsLang(final String language) {

        langCollection.get(language).forEach((k, v)
                -> System.out.println(k + ":" + v));

    }

    public void translate(final String lang, final String word) {

        System.out.println(langCollection.get(lang).get(word));

    }

    public void syncData() throws IOException {

        for (String lang : langCollection.keySet()) {

            Path path = Paths.get(FileService.ROOT_PATH + lang);

            FileChannel.open(path, StandardOpenOption.WRITE).truncate(0).close();

            BufferedWriter writer = Files.newBufferedWriter(path);

            langCollection.get(lang).forEach(
                    (k, v) -> {
                        try {
                            writer.append(k + ":" + v + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );

        }
    }
}