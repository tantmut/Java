package lessons.patterns.delegate;

public interface Graphics {

    void draw();

}

class Triangle implements Graphics {

    @Override
    public void draw() {
        System.out.println("This is triangle");
    }
}

class Square implements Graphics {

    @Override
    public void draw() {
        System.out.println("This is square");
    }
}

class Circle implements Graphics {

    @Override
    public void draw() {
        System.out.println("This is circle");
    }
}

class Painter {
    Graphics graphics;

    public void setGraphics(Graphics g) {
        graphics = g;
    }

    public void draw() {
        graphics.draw();
    }
}

 class Main{
     public static void main(String[] args) {
         Painter p = new Painter();

         p.setGraphics(new Circle());
         p.draw();
     }
 }