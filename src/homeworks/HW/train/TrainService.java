package homeworks.HW.train;


public class TrainService {
    private Train[] trains;

    public TrainService() {
        trains = new Train[10];
        trains[0] = new Train(15, ComfortClass.BUSSINESS, CityArrival.BREST, CityDeparture.DNIPRO, 10, TypeOfTrain.EXPRESS, 185);
        trains[1] = new Train(25, ComfortClass.ECONOM, CityArrival.GDANSK, CityDeparture.KHARKIV, 20, TypeOfTrain.STANDART, 255);
        trains[2] = new Train(18, ComfortClass.LUX, CityArrival.GDANSK, CityDeparture.KYIV, 18, TypeOfTrain.STANDART, 122);
        trains[3] = new Train(20, ComfortClass.STANDART, CityArrival.POLTAVA, CityDeparture.TERNOPIL, 5, TypeOfTrain.EXPRESS, 133);
    }

    //1) Создавать рейс(количество вагонов, класс удобства(использовать enum), город отбытия/прибытия, время в пути, скоростной/нескоростной).
    public void addTrip(Train trip) {
        for (int i = 0; i < trains.length; i++) {
            if (trains[i] == null) {
                trains[i] = trip;
                break;
            }
        }
    }
    //2) Выводить список всех рейсов.

    public void showAllTrips() {
        for (Train trip : trains) {
            if (trip != null)
                System.out.println(trip);
        }
    }
    //3) Выводить список рейсов по городу отбытия/прибытия.

    public void filterByArrival(CityArrival arrival) {
        for (Train trip : trains) {
            if (trip != null && trip.getArrival() == arrival)
                System.out.println(trip);
        }
    }

    public void filterByDeparture(CityDeparture departure) {
        for (Train trip : trains) {
            if (trip != null && trip.getDeparture() == departure)
                System.out.println(trip);
        }
    }

    //4) Просматривать отдельный рейс.
    public void filterById(int id) {
        for (Train trip : trains) {
            if (trip != null && trip.getId() == id)
                System.out.println(trip);
        }
    }

    //5) Выводить рейсы, у которых вагоны типа люкс/эконом.
    public void filterByType(TypeOfTrain type) {
        for (Train trip : trains) {
            if (trip != null && trip.getType() == type)
                System.out.println(trip);
        }
    }
}
