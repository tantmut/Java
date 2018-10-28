package lessons.patterns.builder;

public class    Car {
    private Transmission transmission;
    private String name;
    private int maxSpeed;

    public Car() {
    }


    public Car(Transmission transmission, String name, int maxSpeed) {
        this.transmission = transmission;
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;

    }

    public Car setName(String name) {
        this.name = name;

        return this;
    }

    public Car setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "transmission=" + transmission +
                ", name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

enum Transmission {
    MANUAL, AUTO;
}

class CarBuilder {
    private Transmission transmission;
    private String name;
    private int maxSpeed;

    public CarBuilder() {
        transmission = Transmission.AUTO;
        name = "BMW";
        maxSpeed = 100;
    }

    CarBuilder buildName(String name) {
        this.name = name;

        return this;
    }

    CarBuilder buildMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;

        return this;
    }

    CarBuilder buildTransmission(Transmission transmission) {
        this.transmission = transmission;

        return this;
    }

    public Car build() {
        return new Car(transmission, name, maxSpeed);
    }
}

class TestBuilder {
    public static void main(String[] args) {
        Car bmw = new CarBuilder()
                .buildMaxSpeed(120)
                .buildName("BMW")
                .buildTransmission(Transmission.MANUAL)
                .build();

        System.out.println(bmw);
    }
}