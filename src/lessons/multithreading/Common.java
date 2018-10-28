package lessons.multithreading;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Common {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();

        //myThread.start();

        SecondThread secondThread = new SecondThread();

        Thread thread = new Thread(secondThread);

        thread.start();

        Runnable runnable = () -> {
//            System.out.println("I'm functonal interface");

            System.out.println(Thread.currentThread().getName());

            while (true) {

            }
        };

        Thread thread1 = new Thread(runnable, "Zlodej");

        thread1.setDaemon(true);
 //        thread1.start();

//        thread1.start();

//        thread.join();

//        Thread.yield();

        System.out.println("main thread");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("I'm new thread");
    }
}

class SecondThread implements Runnable {
    @Override
    public void run() {
        System.out.println("I'm runnable");

        while (true) {

        }

        /*try {
            throw new IOException();
        } catch (IOException e) {
            System.out.println(Thread.currentThread().getName());
            e.printStackTrace();
        }*/
    }
}

class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().isInterrupted());

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Inside catch");

                Thread.currentThread().interrupt();

                System.out.println(Thread.currentThread().isInterrupted());

//                e.printStackTrace();
            }

//            System.out.println(Thread.currentThread().interrupted());

//            System.out.println(Thread.currentThread().isInterrupted());



        };

        Thread thread = new Thread(runnable);

        thread.start();

//        Thread.sleep(500);

        thread.interrupt();
    }
}