package homeworks.HW.locale_date;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class LocalDateNow {

    public static void main(String[] args) {
        LocalDate a = LocalDate.now(Clock.systemDefaultZone());
        LocalDate b = LocalDate.now( );


        LocalDate c = LocalDate.of(2014, 6, 30);

        LocalDate d = c.minus(Period.ofDays(1000));

        LocalDate c1 = LocalDate.of(2014, 6, 30);

        LocalDate d2 = c1.plus(Period.ofDays(100));

         String date = "2016-08-16";

        //default, ISO_LOCAL_DATE
        LocalDate localDate = LocalDate.parse(date);

        LocalTime l = LocalTime.now();

        long s = l.until(LocalTime.MIDNIGHT, ChronoUnit.HOURS);


        LocalDate date2 = LocalDate.parse("2017-02-03");

        LocalDate date1 = LocalDate.parse("2017-01-03");

        LocalDateTime a1 = LocalDateTime.of(2014, 6, 30, 12, 01);

        LocalDateTime t = a1.truncatedTo(ChronoUnit.HOURS);


        LocalDate a4 = LocalDate.of(2010, 2, 25);

     }
}
