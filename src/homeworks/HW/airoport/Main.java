package homeworks.HW.airoport;

/**
 * Created by nazar123 on 26.11.2017.
 */
public class Main {
    public static void main(String[] args) {

        FlightService service = new FlightService();
        service.addFligth(new Flight(Countries.POLAND, Countries.Ukraine,
                "13:53", " 15:00", 252, 80));
        service.searchFlyByCountry(Countries.Ukraine, Countries.POLAND );
        service.searchFlyById(10);
        service.smartSearch(Countries.Ukraine, Countries.POLAND, 252);

        service.watchAllfly();

    }

}
