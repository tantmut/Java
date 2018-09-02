package lessons.learn_scanner;

import java.util.Scanner;

/**
 * Created by nazar on 3/26/2017.
 */
public class LearnScanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter some word");

//        String textFromUser = scanner.nextLine();
        int textFromUser = scanner.nextInt();


        Integer.parseInt("15");

        System.out.println("....");
        System.out.println("You entered -> " + textFromUser);
    }
}
