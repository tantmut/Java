package homeworks.HW.calendar;

import net.sf.cglib.core.Local;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

import static java.lang.Integer.parseInt;

public class CalendarService {

    private static final Random RANDOM = new Random();

    private Map<LocalDateTime, List<String>> eventMap;

    public CalendarService( ) {

        eventMap = new HashMap<>();
        eventMap.put(generateDate(), Arrays.asList("Do something", "Do another"));
        eventMap.put(generateDate(), Arrays.asList("Do something1", "Do another1"));
        eventMap.put(generateDate(), Arrays.asList("Do something2", "Do another2"));
        eventMap.put(generateDate(), Arrays.asList("Do something3", "Do another3"));
    }

    public void throwException() {
        throw new NullPointerException("I'm NPE");
    }

//       4) По требованию пользователя выводить в консоль дату через неделю, месяц, год.

    public void showDateInPeriod(String period) {

        ChronoUnit unit = ChronoUnit.DAYS;

        switch (period) {
            case "w":
                unit = ChronoUnit.WEEKS;
                break;
            case "m":
                unit = ChronoUnit.MONTHS;
                break;
            case "y":
                unit = ChronoUnit.YEARS;
                break;
        }


        System.out.println(LocalDate.now().plus(1, unit));
    }

    //день недели,
    //номер дня в году, количество дней оставшеееся до Нового Года.
    public void showAdditionalTimeInformation(int choice) {

        LocalDate localDateTime = LocalDate.now();

        LocalDate lastDayYear =
                localDateTime.with(TemporalAdjusters.lastDayOfYear());

        switch (choice) {
            case 1:
                System.out.println("The day of week is " +
                        localDateTime.getDayOfWeek().toString());
                break;
            case 2:
                System.out.println("The number day of this year is " +
                        Integer.toString(localDateTime.getDayOfYear()));
                break;
            case 3:
                System.out.println("Last " +
                        (lastDayYear.getDayOfYear() - localDateTime.getDayOfYear())
                        + " days to the next New Year");
                break;
            default:
                System.out.println("Incorrect value");
                break;
        }
    }


    public void showDateInExactFormat(int choose) throws IOException {//pass variable

        DateTimeFormatter dateFormatter = getDateFormatter(choose);

        System.out.println(LocalDateTime.now().format(dateFormatter));
    }


    // 3) Позволять пользователю вводить свой город(страну), определить его тайм-зону и
//            выводить текущее время, день недели в этой тайм-зоне.
    public void showExactTimeInTimeZone() {

        String country = getRandomCountries();
        LocalDate currentDate = LocalDate.now(ZoneId.of(country));

        System.out.println("The date is " + currentDate + ". The day of week is "
                + currentDate.getDayOfWeek() + ".");
    }

    public void showEventOnTheDay(int index) {
        Set<LocalDateTime> keySet = eventMap.keySet();

        LocalDateTime date = (LocalDateTime) keySet.toArray()[index];

        for (LocalDateTime event : this.eventMap.keySet()) {
            if (event.isEqual(date)) {
                System.out.println(eventMap.get(event));
            }
        }
    }

    public void createEvent(String... v) {

        LocalDateTime date = generateDate();

        eventMap.putIfAbsent(date, Arrays.asList(v));

    }

    public void showAllEvents() {
        for (LocalDateTime date : this.eventMap.keySet()) {

            List<String> value = eventMap.get(date);

            System.out.println("The date " + date + " has next event(s) " +
                    value);
        }
    }


    public DateTimeFormatter getDateFormatter(int choose) throws IOException {

        String format = "yyyy-MM-dd";

        switch (choose) {
            case 2:
                format = "yyyy-MM-dd  hh:mm a";
                break;
            case 3:
                format = "yyyy/MM/dd HH:mm:ss";
                break;
            case 4:
                format = "dd-M-yyyy hh:mm:ss";
                break;
            case 5:
                format = "yyyy-MM-dd  hh:mm a";
                break;
            case 6:
                format = "yyyy/MM/dd";
                break;
            default:
                format = "yyyy-MM-dd  hh:mm a";
        }

        return DateTimeFormatter.ofPattern(format);
    }

    public Map<LocalDateTime, List<String>> getEventMap() {
        return eventMap;
    }

    public LocalDateTime generateDate() {

        long minDay = LocalDate.of(1900, 1, 1).toEpochDay();

        long maxDay = LocalDate.of(2017, 1, 1).toEpochDay();

        int l = (int) (maxDay - minDay);

        long randomLocalDate = minDay + RANDOM.nextInt(l);

        LocalDate localDate = LocalDate.ofEpochDay(randomLocalDate);

        return LocalDateTime.of(localDate,//simplify
                LocalTime.of(RANDOM.nextInt(24), RANDOM.nextInt(60),
                        RANDOM.nextInt(60)));
    }

    public String getRandomCountries() {
        Timezones[] val = Timezones.values();

        Timezones country = val[RANDOM.nextInt(val.length)];

        return country.getText();
    }

    protected static List<String> addEvents(String... events) {

        return new ArrayList<>(Arrays.asList(events));

    }

    protected void showAllDates() {
        int i = 1;

        for (LocalDateTime event : this.eventMap.keySet()) {
            System.out.println("The " + i + " date " + event.toString());
            i++;
        }

    }
}