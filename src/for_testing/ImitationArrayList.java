package for_testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Scanner;

public class ImitationArrayList {
    private int[] array;

    public static final Path PATH = Paths.get("./Logs/ListLogs.txt");

    public ImitationArrayList() {
        array = new int[0];
    }

    public static void main(String[] args) throws IOException {
        ImitationArrayList list = new ImitationArrayList();
        list.addElement(12);
        list.addElement(13);
        System.out.println(list.getArray().length);
        list.deleteElementByIndex(1);
        System.out.println(list.getArray().length);
    }

    //   1) добавление элементов, учитывать, что массив может быть уже заполнен.
    public void addElement(int element) throws IOException {
        reSize();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = element;
                break;
            }
        }

        String log = "\n" + new Date() + " addElement -> " + element;
        writeLogs(log);
    }

    //TODO: Only for testing
    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    //Descrease on Elements
    public void decreaseSize(int newSize) throws IOException {
        int diff = array.length - newSize;
        int[] temp;
        if (diff > 0) {
            temp = new int[diff];
        } else {
            temp = new int[0];
        }
        for (int i = 0; i < temp.length; i++) {
            temp[i] = array[i];
        }

        array = temp;
        String log = "\n" + new Date() + " decreaseSize -> " + newSize;
        try {
            writeLogs(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Increase on Elements
    public void increaseSize(int newSize) throws IOException {
        int diff = array.length + newSize;
        int[] temp;

        temp = new int[diff];

        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }

        array = temp;

        String log = "\n" + new Date() + " increaseSize -> " + newSize;
        try {
            writeLogs(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //5) вывод элементов в консоль в прямом и обратном порядке.

    public void outpurDirect() throws IOException {//rewrite
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        String log = new Date() + " directToConsole -> ";
        writeLogs(log);

    }

    public void outpurInDirect() throws IOException {//rewrite
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        String log = new Date() + " inDirectToConsole -> ";
        writeLogs(log);
    }

    //sort bubble
    public void bubbleSort() throws IOException {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        String log = new Date() + " bubbleSort -> ";
        writeLogs(log);
    }

    private void reSize() {
        boolean shouldReSize = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                shouldReSize = true;
                break;
            }
        }

        if (!shouldReSize) {

            int[] temp;

            if (array.length == 0){
                temp = new int[array.length + 1];
            }
            else{
                temp = new int[array.length * 2];
            }
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
    }
    // 2) изменение элементов по индексу.

    public void changeElementByIndex(int index, int value) throws IOException {
        if (index >= array.length) {
            System.out.println("Index is incorect");
        } else {
            array[index] = value;

        }
        String log = new Date() + " changeElementByIndex -> " + index + value;
        writeLogs(log);
    }

    public void deleteElementByIndex(int index) throws IOException {
       /* int[] temp = new int[array.length - 1];


        for ( int i = 0; i < array.length; i++){
            if ( i != index){
                temp[i] = array[i];
            }
        }
        array = temp;*/

        int[] temp = new int[array.length - 1];

        for (int i = 0; i < index; ++i) {
            temp[i] = array[i];
        }

        for (int i = index; i < array.length; ++i) {
            if (i == temp.length) {
                break;
            }
            temp[i] = array[i + 1];
        }
        array = temp;

        String log = new Date() + " deleteElementByIndex -> " + index;
        writeLogs(log);
    }

    private void writeLogs(String log) throws IOException {
        //Files.write(PATH, log.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public void readLog() throws IOException {
        StringBuffer buffer = new StringBuffer();

        try (BufferedReader reader = Files.newBufferedReader(PATH)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append("\n" + line);
            }
        }

        System.out.println(buffer.toString());
//        Files.lines(PATH, StandardCharsets.UTF_8).forEach(System.out::println);

    }
}


class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ImitationArrayList list = new ImitationArrayList();

        while (true) {
            menu();
            int key = scanner.nextInt();
            try {
                switch (key) {
                    case 1: {
                        System.out.println("Please type number");
                        int number = scanner.nextInt();
                        list.addElement(number);
                        break;
                    }
                    case 2: {
                        System.out.println("Please type which element you want to change in an array");
                        int number = scanner.nextInt();
                        System.out.println("Please type value");
                        int value = scanner.nextInt();
                        list.changeElementByIndex(number, value);
                        break;
                    }
                    case 3: {
                        System.out.println("Please type which element you want to delete in an array");
                        int number = scanner.nextInt();
                        list.deleteElementByIndex(number);
                        break;
                    }
                    case 4: {
                        System.out.println("Please type how many you want to increase array");
                        int number = scanner.nextInt();
                        list.increaseSize(number);
                        break;
                    }

                    case 5: {
                        System.out.println("Please type how many you want to decrese array");
                        int num = scanner.nextInt();
                        list.decreaseSize(num);
                        break;
                    }

                    case 6: {
                        list.outpurDirect();
                        break;
                    }

                    case 7: {
                        list.outpurInDirect();
                        break;
                    }

                    case 8: {
                        list.bubbleSort();
                        break;
                    }

                    case 9: {
                        list.readLog();
                        break;
                    }
                    default:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Exception" + e);
            }
        }
    }

    public static void menu() {
        System.out.println(
                "1) Add element to the array.\n" +
                        "2) Change element in an array by index.\n" +
                        "3) Delete element by index.\n" +
                        "4) Increase array.\n" +
                        "5) Decrease array.\n" +
                        "6) Output in cosole in direct order.\n" +
                        "7) Output in cosole in indirect order.\n" +
                        "8) Bubble sort.\n" +
                        "9) Read log.\n");
    }
}
