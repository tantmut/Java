package lessons.patterns.facade;

/*Структурный паттерн*/
public class Facade {
    public static void main(String[] args) {
        Computer computer = new Computer();

        computer.startComputer();
    }
}

class Computer {
    private Os os;
    private CPU cpu;
    private HardDrive drive;

    public Computer() {
        os = new Os();
        cpu = new CPU();
        drive = new HardDrive();
    }

    public void startComputer() {
        os.start();
        cpu.run();
        drive.load();
    }
}

class Os {
    public void start() {
        System.out.println("Start OS");
    }
}

class CPU {
    public void run() {
        System.out.println("Run CPU");
    }
}

class HardDrive {
    public void load() {
        System.out.println("Load drive");
    }
}