package homeworks.HW.plain;

/**
 * Created by nazar on 3/20/2017.
 */
public class Main {
    public static void main(String[] args) {
        FlightService service = new FlightService();
        Flight flight = new Flight(CountryArrival.POLAND,
                CountryDeparture.UKRAINE, "13:53", " 15:00", 252, 80);
        Flight fly = flight;

        service.addFligth(fly);
        service.smartSearch(CountryArrival.POLAND, CountryDeparture.UKRAINE, "13:53", 80);

    }

}
