package lessons.multithreading.synchronized_keyword;

/**
 * http://netjs.blogspot.com/2015/06/synchronization-in-java-multithreading-synchronizing-thread.html
 */

// This class' shared object will be accessed by threads
public class MessageThr {

    public static void displayMsg(String msg) {
        synchronized (MessageThr.class) {
            System.out.println("Inside displayMsg method " + Thread.currentThread().getName());

            System.out.println("**" + msg);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("*");
        }
    }

}

class MyClass implements Runnable {
    private Thread t;
    private MessageThr msg;
    private String message;

    MyClass(MessageThr msg, String str) {
        this.msg = msg;
        this.message = str;
        // creating threads, 4 threads will be created
        // all sharing the same object msg
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        msg.displayMsg(message);
    }
}

class SynchronizedDemo {
    public static void main(String[] args) {
        MessageThr msg = new MessageThr();
        MyClass mc1 = new MyClass(msg, "I");
        MyClass mc2 = new MyClass(msg, "am");
        MyClass mc3 = new MyClass(msg, "not");
        MyClass mc4 = new MyClass(msg, "synchronized");
    }
}