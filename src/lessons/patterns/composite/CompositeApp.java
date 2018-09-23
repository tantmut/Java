package lessons.patterns.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {

    public static void main(String[] args) {

        Shape triangle = new Triangle();
        Shape circle = new Circle();
        Shape square = new Square();

        Composite composite = new Composite();
        composite.addComponent(circle);
        composite.addComponent(square);
        composite.addComponent(triangle);

        composite.draw();

    }

    interface Shape {
        void draw();
    }

    static class Triangle implements Shape {

        @Override
        public void draw() {
            System.out.println("triangle");
        }
    }

    static class Circle implements Shape {

        @Override
        public void draw() {
            System.out.println("Circle");

        }
    }

    static class Square implements Shape {

        @Override
        public void draw() {
            System.out.println("Square");

        }
    }

    static class Composite implements Shape {

        private List<Shape> components = new ArrayList<>();

        public void addComponent(Shape component) {
            components.add(component);
        }

        public void removeComponent(Shape component) {
            components.remove(component);
        }

        @Override
        public void draw() {
            for (Shape component : components) {
                component.draw();
            }
        }
    }
}
