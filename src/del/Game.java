package del;

public class Game {

    public Game(int a, String b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int a;
    public String b;
    public int c;


    public int addTwoNumber(int a, int b) {
        return a + b;
    }

    public void printAandC() {
        System.out.println("The value of 'a' is " + a +
                "\nThe value of 'c' is " + c+"\n");
    }

}
