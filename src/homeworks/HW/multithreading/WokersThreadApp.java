package homeworks.HW.multithreading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static homeworks.HW.multithreading.WokersThreadApp.PATH_TO_FILE;

public class WokersThreadApp {

    protected static final String PATH_TO_FILE = "./file_for_testing/Story.txt";

    public static void main(String[] args) throws InterruptedException {

        Worker worker = new Worker("like");
        Worker worker1 = new Worker("in");
        Worker worker2 = new Worker("like");
        Worker worker3 = new Worker("like");
        Worker worker4 = new Worker("like");

        List<Worker> workers = Arrays.asList(worker, worker1, worker2, worker3, worker4);

        worker.start();
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        worker.join();
        worker1.join();
        worker2.join();
        worker3.join();
        worker4.join();

        workers.stream().forEach(w -> System.out.println(w.getRunTime()));

    }
}

class Worker extends Thread {

    private String word;

    public Worker(String word) {
        this.word = word;
    }

    @Override
    public void run() {

        try (Stream<String> stream = Files.lines(Paths.get(PATH_TO_FILE))) {

            stream.forEach(f -> {
                if (f.equals(word)) ;
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getRunTime() {
        long startTime = System.currentTimeMillis();

        run();

        long endTime = System.currentTimeMillis() - startTime;

        return endTime;
    }
}
