package lessons.cloning;

public class Original implements Cloneable {
    private String firstName;
    private int age;

    public Original(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public Original clone() throws CloneNotSupportedException {
        return (Original) super.clone();
    }
}

class TestCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Original original = new Original("John", 23);

        Original clone = original.clone();

        System.out.println(clone.getAge() + "\n" + clone.getFirstName());
    }
}
