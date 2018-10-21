package homeworks.HW.patterns;

public class Decorator {

    public static void main(String[] args) {

        PrinterInterface print = new SquareBrackets(new Brackets(new QuotesDecorator
                (new Printer("Hello"))));
        print.print();
    }
}
interface PrinterInterface {
    void print();
}

class Printer implements PrinterInterface {
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

    public SquareBrackets(PrinterInterface component) {
        super(component);
    }

    public void print(){
        System.out.print("[");
        super.print();
        System.out.print("]");
    }
}

class  Brackets extends Decor {

    public Brackets(PrinterInterface component) {
        super(component);
    }

    public void print(){
        System.out.print("{");
        super.print();
        System.out.print("}");
    }
}
class  QuotesDecorator extends Decor {

    public QuotesDecorator(PrinterInterface component) {
        super(component);
    }

    public void print(){
        System.out.print("\"");
        super.print();
        System.out.print("\"");

    }
}

abstract class Decor implements PrinterInterface {
    PrinterInterface component;

    public Decor(PrinterInterface component) {
        this.component = component;
    }

    public void print(){
        component.print();
    }
}