package lessons.patterns.decorator;

/*Structural pattern*/
public interface Printable {//[\Hello\]
    void print();
}

abstract class DecoratorPrint implements Printable {
    Printable printable;

    DecoratorPrint(Printable printable) {
            this.printable = printable;
    }
    public void print(){
        printable.print();
    }
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

class LeftBracket extends DecoratorPrint {
    private Printable printable;

    public LeftBracket(Printable printable) {
        super(printable);
    }

    @Override
    public void print() {
        System.out.print("[");
        super.print();
    }
}

class RightBracket extends DecoratorPrint {
    private Printable printable;

    public RightBracket(Printable printable) {
        super(printable);
    }

    @Override
    public void print() {
        super.print();
        System.out.print("]");
    }
}

class BackSlash extends DecoratorPrint {
    private Printable printable;

    public BackSlash(Printable printable) {
        super(printable);
    }

    @Override
    public void print() {
        System.out.print("\\");
        super.print();
        System.out.print("\\");
    }
}


class TestDecorator {
    public static void main(String[] args) {
        Printable hello = new BackSlash(new LeftBracket(new RightBracket(new RealPrinter("hello"))));

        hello.print();
    }
}



