package homeworks.HW.patterns;

public class Decorator {

    public static void main(String[] args) {

        Printable print = new SquareBrackets(new Brackets(new QuotesDecorator
                (new Printer("Hello"))));
        print.print();
    }
}

interface Printable {
    void print();
}

class Printer implements Printable {
    private String value;

    Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}

class SquareBrackets extends Decor {

    public SquareBrackets(Printable component) {
        super(component);
    }

    public void print() {
        System.out.print("[");
        super.print();
        System.out.print("]");
    }
}

class Brackets extends Decor {

    public Brackets(Printable component) {
        super(component);
    }

    public void print() {
        System.out.print("{");
        super.print();
        System.out.print("}");
    }
}

class QuotesDecorator extends Decor {

    public QuotesDecorator(Printable component) {
        super(component);
    }

    public void print() {
        System.out.print("\"");
        super.print();
        System.out.print("\"");

    }
}

abstract class Decor implements Printable {
    Printable component;

    public Decor(Printable component) {
        this.component = component;
    }

    public void print() {
        component.print();
    }
}