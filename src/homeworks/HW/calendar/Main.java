package homeworks.HW.calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader BUFFERED_READER =
            new BufferedReader(new InputStreamReader(System.in));
    private static int choice;


    public static void main(String[] args) {

        try {
            CalendarService service = new CalendarService();

            getMessegeDateFormate();
            choice = Integer.parseInt(BUFFERED_READER.readLine());
            service.showDateInExactFormat(choice);

            service.showDateInPeriod("y");

            getMessegeAdditionalTimeInformation();
            choice = Integer.parseInt(BUFFERED_READER.readLine());
            service.showAdditionalTimeInformation(choice);

            service.showExactTimeInTimeZone();

            System.out.println("Please choose the date to see the events, using numbers: ");
            service.showAllDates();

            choice = Integer.parseInt(BUFFERED_READER.readLine());

            service.showEventOnTheDay(choice);

            service.createEvent("Do something", "two", "clock");
            service.createEvent("Do something", "two", "clock111");


            service.showAllEvents();
        } catch (IOException e) {
            System.err.println("Error: " + e);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number");
        }
    }

    private static void getMessegeDateFormate() {
        System.out.println("Please choose next format:\n" +
                "1 - \"yyyy-MM-dd\"\n" +
                "2 -\"yyyy-MM-dd  hh:mm a\"\n" +
                "3 - \"yyyy/MM/dd HH:mm:ss\"\n" +
                "4 -\"dd-M-yyyy hh:mm:ss\"\n" +
                "5 - \"yyyy-MM-dd  hh:mm a\"\n" +
                "6 -\"yyyy/MM/dd\""
        );
    }

    private static void getMessegeAdditionalTimeInformation() {
        System.out.println("Choose what would you like to see:\n" +
                "1 - the day of week\n" +
                "2 - the number day of this year\n" +
                "3 -how many days last to the end of the year");
    }
}
