package homeworks.HW.train;

/**
 * Created by nazar on 3/26/2017.
 */
public class Main {
    public static void main(String[] args) {
        TrainService service = new TrainService();
        Train train = new Train(12, ComfortClass.BUSSINESS, CityArrival.KHARKIV,
                CityDeparture.VARSHAVA, 20, TypeOfTrain.EXPRESS, 185);
        service.addTrip(train);
        service.filterByType(TypeOfTrain.EXPRESS);
    }

}