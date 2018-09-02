package homeworks.HW.airoport;

/**
 * Created by nazar123 on 26.11.2017.
 */
public class Flight {
    private Countries arrival;
    private Countries departure;//delete the field
    private String timeArrival;
    private String timeDeparture;
    private int id;
    private int place;

    @Override
    public String toString() {
        return "Number fly is " + id +
                ". The plain is flying from " + departure +
                " to " + getArrival() +
                ". The departure time is " + getTimeDeparture() +
                ". The arrival time is " + getTimeArrival();
    }


    public Countries getArrival() {
        return arrival;
    }

    public Countries getDeparture() {
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

    public Flight(Countries arrival, Countries departure,
                  String timeArrival, String timeDeparture, int id, int place) {
        this.arrival = arrival;
        this.departure = departure;
        this.timeArrival = timeArrival;
        this.timeDeparture = timeDeparture;
        this.id = id;
        this.place = place;
    }


}
