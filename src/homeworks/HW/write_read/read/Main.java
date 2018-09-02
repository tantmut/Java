package homeworks.HW.write_read.read;

import homeworks.HW.TestArrayList;
import homeworks.HW.write_read.write.WriteData;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by nazar on 4/2/2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter some text");

        String text = scanner.nextLine();

        new WriteData().write(text);

        /*System.out.println(ReaderData.read1(ReaderData.getFileName()));
        modifyText(ReaderData.read1(ReaderData.getFileName()));*/
    }
}
