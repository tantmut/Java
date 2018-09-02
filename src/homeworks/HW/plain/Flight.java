package homeworks.HW.plain;

/**
 * Created by nazar on 3/20/2017.
 */
public class Flight {

    private CountryArrival arrival;
    private CountryDeparture departure;
    private String timeArrival;
    private String timeDeparture;
    private int id;
    private int place;

    public Flight(CountryArrival arrival, CountryDeparture departure, String timeArrival, String timeDeparture, int id, int place) {
        this.arrival = arrival;
        this.departure = departure;
        this.timeArrival = timeArrival;
        this.timeDeparture = timeDeparture;
        this.id = id;
        this.place = place;
    }

    public CountryArrival getArrival() {
        return arrival;
    }

    public CountryDeparture getDeparture() {
        return departure;
    }

    public String getTimeArrival() {
        return timeArrival;
    }

    public String getTimeDeparture() {
        return timeDeparture;
    }

    public int getId() {
        return id;
    }

    public int getPlace() {
        return place;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "arrival=" + arrival +
                ", departure=" + departure +
                ", timeArrival='" + timeArrival + '\'' +
                ", timeDeparture='" + timeDeparture + '\'' +
                ", id=" + id +
                ", place=" + place +
                '}';
    }

}
