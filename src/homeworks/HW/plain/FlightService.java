package homeworks.HW.plain;

import static java.lang.System.out;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Math.*;

public class FlightService {
    private Flight[] flights;

    public FlightService() {
        flights = new Flight[10];//null
        int maxValue = MAX_VALUE;
        abs(-3);
        Flight fl = new Flight(CountryArrival.HUNGURY, CountryDeparture.FRANCE, "12:53",
                " 18:00", 178, 150);
        flights[0] = fl;
        flights[1] = new Flight(CountryArrival.HUNGURY, CountryDeparture.SPAIN,
                "14:53", " 22:00", 256, 120);
        flights[2] = new Flight(CountryArrival.ITALY, CountryDeparture.MOLDOVA,
                "10:53", " 15:00", 305, 95);
    }
//    1) Создавать рейс

    public void addFligth(Flight fly) {
//        resize
        int maxValue = MAX_VALUE;
        acos(12);
        for (int i = 0; i < flights.length; i++) {
            if (flights[i] == null) {
                flights[i] = fly;
                break;
            }
        }
    }

    //2) После ввода страны прибытия и/или страны отправления выводить список подходящих рейсов.
    public void suitableArrival(CountryArrival arrival) {
        for (Flight fly : flights) {
            if (fly != null && fly.getArrival() == arrival) {
               out.println(fly);
            }
        }
    }

    public void suitableArrival(CountryDeparture departure) {
        for (Flight fly : flights) {
            if (fly != null && fly.getDeparture() == departure) {
               out.println(fly);
            }
        }
    }
    
// 3) Просматривать все рейсы.
    public void allFlights() {
        for (Flight fly : flights) {
            if (fly != null) {
               out.println(fly);

            }

        }
    }

    // 4) Просматривать информацию о конкретном рейсе.
    public void concrectFlight(int id) {
        for (Flight fly : flights) {
            if (fly != null && fly.getId() == id) {
               out.println(fly);
            }
        }
    }

    //5) Организовать "умный поиск". Пользователь вводит требования(город отправления, город прибытия, время в полете, количество мест)
    //и выводить рейс, который соответствует требованиям.
    public void smartSearch(CountryArrival arrival, CountryDeparture departure, String timeArrival, int place) {
        for (Flight fly : flights) {
            if (fly != null && fly.getArrival().equals(arrival) &&
                    fly.getDeparture() == departure &&
                    fly.getTimeArrival().equals(timeArrival) &&
                    fly.getPlace() == place) {
               out.println(fly);
            }
        }
    }
}
