package del;

public class SuperGame extends Game {

    public SuperGame(int a, String b, int c) {
        super(a, b, c);
    }

    public int multipleTwoNumber(int a, int b) {
        return a * b;
    }


    public void setA(int a) {
        this.a = a;
    }

    public void print(){
        System.out.println("It's a" + b);
    }
}
