package lessons.multithreading.synchronized_keyword;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class FinTrans {
    private String name;
    private double amount;

    public FinTrans(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

class Bank {
    public static void main(String[] args) {
        FinTrans finTrans = new FinTrans("FinTrans", 2000);

        FinThread deposit = new FinThread("Deposit", finTrans);


        FinThread withDrawal = new FinThread("WithDrawal", finTrans);

        deposit.start();
        withDrawal.start();
    }
}

class FinThread extends Thread {
    private FinTrans finTrans;

    public FinThread(String name, FinTrans finTrans) {
        super(name);
        this.finTrans = finTrans;
    }

    @Override
    public void run() {
        IntStream.range(0, 5).forEach(index -> {

            String name = Thread.currentThread().getName();

            synchronized (finTrans) {

            if (name.equals("Deposit")) {
                finTrans.setName("Deposit");

                try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                finTrans.setAmount(2000);

            } else {
                finTrans.setName("WithDrawal");

                try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                finTrans.setAmount(500);


            }

            System.out.println(finTrans.getName() + "\t" + finTrans.getAmount());

        }});
    }
}

