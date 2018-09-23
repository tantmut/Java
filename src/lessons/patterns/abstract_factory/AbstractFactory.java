package lessons.patterns.abstract_factory;

public class AbstractFactory {

    public static void main(String[] args) {

        DeviceFactory deviceFactory = new RuDeviceFactory();
        KeyBoard keyBoard = deviceFactory.getKeyBoard();
        keyBoard.print();

    }

    interface Mouse {
        void click();

        void dclick();

        void scroll();

    }

    interface KeyBoard {
        void print();

        void printLn();

    }

    interface TouchPad {
        void track();
    }

    interface DeviceFactory {
        Mouse getMouse();

        KeyBoard getKeyBoard();

        TouchPad getTouchPad();
    }

    static class ruMouse implements Mouse {

        @Override
        public void click() {
            System.out.println("Mouse ClickRU");

        }

        @Override
        public void dclick() {
            System.out.println("Mouse dClickRU");

        }

        @Override
        public void scroll() {
            System.out.println("Mouse scrollRU");

        }
    }

    static class ruKeyBoard implements KeyBoard {

        @Override
        public void print() {
            System.out.println("printRU");

        }

        @Override
        public void printLn() {
            System.out.println("printLnRU");

        }
    }


    static class ruTouchPad implements TouchPad {

        @Override
        public void track() {
            System.out.println("trackRU");

        }
    }

    static class engMouse implements Mouse {

        @Override
        public void click() {
            System.out.println("Mouse Click");

        }

        @Override
        public void dclick() {
            System.out.println("Mouse dClick");

        }

        @Override
        public void scroll() {
            System.out.println("Mouse scroll");

        }
    }

    static class engKeyBoard implements KeyBoard {

        @Override
        public void print() {
            System.out.println("print");

        }

        @Override
        public void printLn() {
            System.out.println("printLn");

        }
    }


    static class engTouchPad implements TouchPad {

        @Override
        public void track() {
            System.out.println("track");

        }
    }

    static class RuDeviceFactory implements DeviceFactory {

        @Override
        public Mouse getMouse() {
            return new ruMouse();
        }

        @Override
        public KeyBoard getKeyBoard() {
            return new ruKeyBoard();
        }

        @Override
        public TouchPad getTouchPad() {
            return new ruTouchPad();
        }
    }


    static class EngDeviceFactory implements DeviceFactory {

        @Override
        public Mouse getMouse() {
            return new ruMouse();
        }

        @Override
        public KeyBoard getKeyBoard() {
            return new ruKeyBoard();
        }

        @Override
        public TouchPad getTouchPad() {
            return new ruTouchPad();
        }
    }
}
