package homeworks.HW.airoport;

/**
 * Created by nazar123 on 26.11.2017.
 */
public class FlightService {
    private Flight[] flights;

    public FlightService() {

        flights = new Flight[2];
        flights[0] = new Flight(Countries.POLAND, Countries.Ukraine,
                "dlld", "dll", 10, 15);

        flights[1] = new Flight(Countries.POLAND, Countries.Ukraine,
                "asd", "sasf", 7, 4);
    }


    public void addFligth(Flight fly) {
        reSize();

        for (int i = 0; i < flights.length; i++) {
            if (flights[i] == null) {
                flights[i] = fly;
                break;
            }
        }
    }


    private void reSize() {
        boolean shouldReSize = false;

        for (int i = 0; i < flights.length; i++) {
            if (flights[i] == null) {
                shouldReSize = true;
                break;
            }
        }

        if (!shouldReSize) {
            Flight[] temp = new Flight[flights.length * 2];
            for (int i = 0; i < flights.length; i++) {
                temp[i] = flights[i];
            }
            flights = temp;
        }
    }

    public void smartSearch(Countries arrival, Countries departure, int id) {//rewrite
        for (int i = 0; i < flights.length; i++) {
            Flight flight = flights[i];
            if (flight != null &&
                    flight.getArrival() == arrival &&
                    flight.getDeparture() == departure &&
                    flight.getId() == id) {
                System.out.println(flight.toString());
            }
        }
    }

    public void watchAllfly() {
        for (Flight fly : flights) {
            if (fly != null) {
                System.out.println(fly.toString());

            }
        }
    }

    public void searchFlyByCountry(Countries departure, Countries arrival) {
        for (int i = 0; i < flights.length; i++) {
            if (flights[i] != null && flights[i].getDeparture().equals(departure)
                    && flights[i].getArrival().equals(arrival)) {
                System.out.println(flights[i].toString());
            }
        }
    }

    public void searchFlyById(int id) {
        for (int i = 0; i < flights.length; i++) {
            if (flights[i] != null && flights[i].getId() == id) {
                System.out.println(flights[i].toString());
            }
        }
    }
}
