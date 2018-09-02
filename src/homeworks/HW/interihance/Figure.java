package homeworks.HW.interihance;

/**
 * Created by nazar123 on 30.01.2018.
 */
public class Figure implements Calcutable {

    private int length;
    private int height;

    public Figure(int length, int height) {
        this.length = length;
        this.height = height;
    }

    public int calculateSquare() {
        return length * height;
    }

    public static void main(String[] args) {

        Figure triangle = new Triangle(8, 4);
        Figure parallelogram = new Parallelogram(15, 17);
        Figure romb = new Romb(24, 9);

        triangle.print();
        parallelogram.print();
        romb.print();
    }
}


