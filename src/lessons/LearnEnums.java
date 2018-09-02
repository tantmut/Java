package lessons;


enum Cities {
    KIEV("Kiev"), LVIV("Lviv");

    private String shortName;

    Cities(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }
}

//Wuman, Wooman, wyMan

public class LearnEnums {
    public static void main(String[] args) {
//        Cities cities = Cities.LVIV;
//        print(cities);
        String city = "Lviv";
//        Cities cities = Cities.valueOf(city.toUpperCase());
        Cities[] cities = Cities.values();
        for (Cities c : cities) {
            System.out.println(c.getShortName());
        }
    }

    public static void print(Cities city) {
        System.out.println(city.getShortName());
    }
}
