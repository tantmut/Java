package lessons.patterns.factory;

public class Factory {

    public static void main(String[] args) {


        WatchMaker watchMaker = new DigitallWatchMaker();

        Watch watch = watchMaker.createWatch();

        watch.showTime();
    }

    interface Watch {
        void showTime();
    }

    static class DigitallWatch implements Watch {
        @Override
        public void showTime() {
            System.out.println("This is 10 hours");
        }
    }

    static class RomanWatch implements Watch {
        @Override
        public void showTime() {
            System.out.println("This is X hours");
        }
    }

    interface WatchMaker{
        Watch createWatch();
    }

    static class DigitallWatchMaker implements WatchMaker{

        @Override
        public Watch createWatch() {
            return new DigitallWatch();
        }
    }

    static class RomanWatchMaker implements WatchMaker{

        @Override
        public Watch createWatch() {
            return new RomanWatch();
        }
    }

}
