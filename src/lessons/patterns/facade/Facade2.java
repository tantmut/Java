package lessons.patterns.facade;

public class Facade2 {

    // Скрывает всю сложность системы. Мы общаемся с системой через фасад
    public static void main(String[] args) {

        Computer computer = new Computer();
        computer.copy();
    }

    static class Power {

        public void turnOn() {

        }

        public void turnOff() {

        }
    }

    static class DvdRom {

        public boolean data = false;

        public boolean hasdata() {
            return data;
        }

        public void load() {
            data = true;
        }

        public void unload() {
            data = false;
        }
    }

    static class HDD {

        public void copyFromDVD(DvdRom dvdRom) {
            if (dvdRom.hasdata()) {
                System.out.println("Copy data from disk");
            } else {
                System.out.println("Turn on disk");
            }

        }
    }

    static class Computer {

        private HDD hdd = new HDD();
        private DvdRom dvdRom = new DvdRom();
        private Power power = new Power();

        public void copy() {
            power.turnOn();
            dvdRom.load();
            hdd.copyFromDVD(dvdRom);
        }
    }
}
