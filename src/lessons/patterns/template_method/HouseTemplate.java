package lessons.patterns.template_method;

/*Поведенческий паттерн*/
public abstract class HouseTemplate {

    public final void buildHouse() {
       buildFoundation();
       buildPillars();
       buildWalls();
       buildWindows();
       System.out.println("House is built");
    }

    private void buildWindows() {
        System.out.println("Install glass windows");
    }

    private void buildFoundation() {
        System.out.println("Install foundation");
    }

    public abstract void buildWalls();

    public abstract void buildPillars();
}

class GlassHouse extends HouseTemplate {
    @Override
    public void buildWalls() {
        System.out.println("Build glass walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Build glass pillars");
    }
}

class WoodHouse extends HouseTemplate {
    @Override
    public void buildWalls() {
        System.out.println("Build wood walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Build wood pillars");
    }
}

class TestTemplateMethod {
    public static void main(String[] args) {
        GlassHouse glassHouse = new GlassHouse();

        glassHouse.buildHouse();
    }
}

