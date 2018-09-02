package homeworks.HW.train;

/**
 * Created by nazar on 3/26/2017.
 */
public class Train {
    private  int carriage;
    private ComfortClass comfort;
    private CityArrival arrival;
    private CityDeparture departure;
    private int time;
    private TypeOfTrain type;
    private int id;

    public Train(int carriage, ComfortClass comfort, CityArrival arrival,
                 CityDeparture departure, int time, TypeOfTrain type, int id) {
        this.carriage = carriage;
        this.comfort = comfort;
        this.arrival = arrival;
        this.departure = departure;
        this.time = time;
        this.type = type;
        this.id = id;
    }

    public int getCarriage() {
        return carriage;
    }

    public ComfortClass getComfort() {
        return comfort;
    }

    public CityArrival getArrival() {
        return arrival;
    }

    public CityDeparture getDeparture() {
        return departure;
    }

    public int getTime() {
        return time;
    }

    public TypeOfTrain getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "train{" +
                "carriage=" + carriage +
                ", comfort=" + comfort +
                ", arrival=" + arrival +
                ", departure=" + departure +
                ", time=" + time +
                ", type=" + type +
                ", id=" + id +
                '}';
    }

}
