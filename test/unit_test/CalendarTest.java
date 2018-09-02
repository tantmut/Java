package unit_test;

import homeworks.HW.calendar.CalendarService;
import homeworks.HW.calendar.Timezones;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static org.mockito.Mockito.when;


@RunWith(PowerMockRunner.class)
@PrepareForTest(CalendarService.class)
public class CalendarTest {

    @Spy
    CalendarService service = new CalendarService();

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    @Before
    public void beforeEachTest() {
        service.getEventMap().clear();
    }

    @Test
    public void shouldAddEvent()  {

        LocalDateTime date = LocalDateTime.of(2018, 3, 25, 0, 0);

        when(service.generateDate()).thenReturn(date);

        String dayNazar = "Birth Day Nazar";

        service.createEvent(dayNazar);

        service.showAllEvents();

        Map<LocalDateTime, List<String>> eventMap = service.getEventMap();

        Assert.assertTrue(eventMap.containsKey(date));

        Assert.assertTrue(eventMap.get(date).contains(dayNazar));

        Assert.assertTrue(outRule.getLog().contains(dayNazar));
    }


    @Test
    public void shouldReturnDateInPeriod() {

        LocalDate date = LocalDate.now();

        service.showDateInPeriod("d");
        Assert.assertTrue(outRule.getLog().contains((date.plus(1, ChronoUnit.DAYS).toString())));

        service.showDateInPeriod("w");
        Assert.assertTrue(outRule.getLog().contains((date.plus(1, ChronoUnit.WEEKS).toString())));

        service.showDateInPeriod("m");
        Assert.assertTrue(outRule.getLog().contains((date.plus(1, ChronoUnit.MONTHS).toString())));

        service.showDateInPeriod("y");
        Assert.assertTrue(outRule.getLog().contains((date.plus(1, ChronoUnit.YEARS).toString())));
    }

    @Test
    public void shouldShowAdditionalTimeInformation() {

        LocalDate date = LocalDate.now();

        LocalDate lastDayYear =
                date.with(TemporalAdjusters.lastDayOfYear());

        Logger.getLogger("Positive Tests");

        service.showAdditionalTimeInformation(1);

        Assert.assertTrue(outRule.getLog().contains(("The day of week is " +
                date.getDayOfWeek().toString())));

        service.showAdditionalTimeInformation(2);
        Assert.assertTrue(outRule.getLog().contains(("The number day of this year is " +
                date.getDayOfYear())));

        service.showAdditionalTimeInformation(3);
        Assert.assertTrue(outRule.getLog().contains(("Last " +
                (lastDayYear.getDayOfYear() - date.getDayOfYear())
                + " days to the next New Year")));

        Logger.getLogger("Positive Tests");

        service.showAdditionalTimeInformation(0);

        Assert.assertTrue(outRule.getLog().contains(("Incorrect value")));

        service.showAdditionalTimeInformation(4);
        Assert.assertTrue(outRule.getLog().contains(("Incorrect value")));
    }

    @Test
    public void shouldShowDateInExactFormat() throws IOException {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        when(service.getDateFormatter(1)).thenReturn(dateFormatter);
        service.showDateInExactFormat(1);
        Assert.assertTrue(outRule.getLog().contains((LocalDateTime.now().format(dateFormatter))));

        dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  hh:mm a");

        when(service.getDateFormatter(2)).thenReturn(dateFormatter);
        service.showDateInExactFormat(2);
        Assert.assertTrue(outRule.getLog().contains((LocalDateTime.now().format(dateFormatter))));


        dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        when(service.getDateFormatter(3)).thenReturn(dateFormatter);
        service.showDateInExactFormat(3);
        Assert.assertTrue(outRule.getLog().contains((LocalDateTime.now().format(dateFormatter))));

    }

    @Test
    public void shouldShowExactTimeInTimeZone() {

        String country = Timezones.values()[0].getText();
        LocalDate currentDate = LocalDate.now(ZoneId.of(country));

        when(service.getRandomCountries()).thenReturn(country);
        service.showExactTimeInTimeZone();
        Assert.assertTrue(outRule.getLog().contains(
                ("The date is " + currentDate + ". The day of week is "
                        + currentDate.getDayOfWeek() + ".")
        ));

        country = Timezones.values()[1].getText();
        currentDate = LocalDate.now(ZoneId.of(country));

        when(service.getRandomCountries()).thenReturn(country);
        service.showExactTimeInTimeZone();
        Assert.assertTrue(outRule.getLog().contains(
                ("The date is " + currentDate + ". The day of week is "
                        + currentDate.getDayOfWeek() + ".")
        ));
    }

    @Test
    public void shouldShowAllEventsAndShouldShowEventOnTheDay() throws IOException {

        LocalDateTime date = LocalDateTime.of(2018, 3, 25, 0, 0);
        String dayNazar = "Birth Day Nazar";

        when(service.generateDate()).thenReturn(date);
        service.createEvent(dayNazar);

        LocalDateTime date1 = LocalDateTime.of(2017, 3, 25, 0, 0);
        String newYear = "New Year";

        when(service.generateDate()).thenReturn(date1);
        service.createEvent(newYear);

        service.showAllEvents();

        Assert.assertTrue(outRule.getLog().contains(
                dayNazar
        ));
        Assert.assertTrue(outRule.getLog().contains(newYear));

        service.showEventOnTheDay(0);
        Assert.assertTrue(outRule.getLog().contains(
                service.getEventMap().get(date).toString()
        ));

        service.showEventOnTheDay(1);
        Assert.assertTrue(outRule.getLog().contains(
                service.getEventMap().get(date1).toString()
        ));
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

//    @Test(expected = NullPointerException.class) //without rule
    @Test//with rule
    public void shouldThrowException() {
        exception.expect(NullPointerException.class);

        service.throwException();

        exception.expectMessage("I'm NPE");
    }
}
