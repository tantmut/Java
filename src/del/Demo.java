package del;

public class Demo extends AbstractDemo {

    @Override
    protected String print() {
        return "dlfl";
    }

    public static void main(String[] args) {

        final Demo d = new Demo();

        d.print();

    }
}
