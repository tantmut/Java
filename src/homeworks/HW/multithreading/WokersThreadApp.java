package homeworks.HW.multithreading;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static homeworks.HW.multithreading.WokersThreadApp.PATH_TO_FILE;

public class WokersThreadApp {

    protected static final String PATH_TO_FILE = "./file_for_testing/Story.txt";

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        Worker worker1 = new Worker();
        Worker worker2 = new Worker();
        Worker worker3 = new Worker();
        Worker worker4 = new Worker();

        worker.start();
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        worker.join(22222);
        worker1.join();
        worker2.join();
        worker3.join();
        worker4.join();


        /*System.out.println(worker.getRunTime("like"));
        System.out.println(worker1.getRunTime("in"));
        System.out.println(worker2.getRunTime("like"));
        System.out.println(worker3.getRunTime("like"));
        System.out.println(worker4.getRunTime("like"));*/

    }
}

class Worker extends Thread {

    /*@Override
    public void run() {
        int count = 0;

        try {
            Scanner s = new Scanner(new File(PATH_TO_FILE));//lambda

            while (s.hasNext()) {
                if (s.next().equals(word)) count++;
            }
        } catch (IOException e) {
            System.out.println("Error accessing input file!");
        }
//        return count;
    }

    public long getRunTime(final String word) {
        long startTime = System.currentTimeMillis();

        readFile(word);

        long time = System.currentTimeMillis() - startTime;

        return time;
    }*/
}
