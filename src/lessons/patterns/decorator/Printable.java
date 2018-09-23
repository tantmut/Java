package lessons.patterns.decorator;
/*Structural pattern*/
public interface Printable {//[\Hello\]
    void print();
}

class RealPrinter implements Printable {

    private String text;

    public RealPrinter(String text) {
        this.text = text;
    }

    @Override
    public void print() {
        System.out.print(text);
    }
}

class LeftBracket implements Printable {
    private Printable printable;

    public LeftBracket(Printable printable) {
        this.printable = printable;
    }

    @Override
    public void print() {
        System.out.print("[");
        printable.print();
    }
}

class RightBracket implements Printable {
    private Printable printable;

    public RightBracket(Printable printable) {
        this.printable = printable;
    }

    @Override
    public void print() {
        printable.print();
        System.out.print("]");
    }
}

class BackSlash implements Printable {
    private Printable printable;

    public BackSlash(Printable printable) {
        this.printable = printable;
    }

    @Override
    public void print() {
        System.out.print("\\");
        printable.print();
        System.out.print("\\");
    }
}

class TestDecorator {
    public static void main(String[] args) {
        BackSlash hello = new BackSlash(new LeftBracket(new RightBracket(new RealPrinter("Hello"))));

        hello.print();
    }
}



