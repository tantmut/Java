package lessons.patterns.builder;

public abstract class CarBuilder2 {

    Car car;

    void createCar() {
        car = new Car();
    }

    abstract void buildName();

    abstract void buildTransmission();

    abstract void buildMaxSpeed();

    Car getCar() {
        return car;
    }

    static class FordMondeo extends CarBuilder2 {

        @Override
        void buildName() {
            car.setName("Fort Mondeo");
        }

        @Override
        void buildTransmission() {
            car.setTransmission(Transmission.AUTO);

        }

        @Override
        void buildMaxSpeed() {
            car.setMaxSpeed(250);

        }
    }

    static class MersedesBens extends CarBuilder2 {

        @Override
        void buildName() {
            car.setName("MersedesBens");
        }

        @Override
        void buildTransmission() {
            car.setTransmission(Transmission.AUTO);

        }

        @Override
        void buildMaxSpeed() {
            car.setMaxSpeed(320);

        }
    }


    static class Director {

        CarBuilder2 builder;

        void setBuilder(CarBuilder2 b) {
            this.builder = b;
        }

        Car buildCar() {
            builder.createCar();
            builder.buildName();
            builder.buildMaxSpeed();
            builder.buildTransmission();
            Car car = builder.getCar();
            return car;

        }

        public static void main(String[] args) {
            Director director = new Director();
            director.setBuilder(new MersedesBens());
            director.setBuilder(new FordMondeo());

            Car mersedes = director.buildCar().setMaxSpeed(290).setName("Ford");

            System.out.println(mersedes);

            Car fort = director.buildCar();
            System.out.println(fort);

        }
    }
}