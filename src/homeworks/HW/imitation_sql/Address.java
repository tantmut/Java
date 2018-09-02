package homeworks.HW.imitation_sql;

public class Address {

    private String street;
    private String city;
    private String country;
    private int numberOfHome;
    private int amountOfPeople;

    public Address(String country, String city, String street, int numberOfHome, int amountOfPeople) {

        this.country = country;
        this.city = city;
        this.street = street;
        this.numberOfHome = numberOfHome;
        this.amountOfPeople = amountOfPeople;
    }

    public String getCountry() {
        return country;
    }


    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getNumberOfHome() {
        return numberOfHome;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", numberOfHome=" + numberOfHome +
                ", amountOfPeople=" + amountOfPeople +
                '}';
    }

}
