package lessons.patterns.prototype;

public class Prototype {

    public static void main(String[] args) {

        Human original = new Human(17, "Vasyl");
        System.out.println(original.toString());
        Human copy = (Human) original.copy();
        System.out.println(copy.toString());

        HumanFactoryMaker humanFactoryMaker = new HumanFactoryMaker(original);
        Human copy1 = humanFactoryMaker.makecopy();

        System.out.println(copy1);

    }

    interface Copyable {
        Object copy();
    }

    static class Human implements Copyable {
        int age;
        String name;

        @Override
        public String toString() {
            return "Human{" +
                    "age=" + age +
                    ", name=" + name +
                    '}';
        }

        public Human(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public Object copy() {
            Human human = new Human(age, name);
            return human;
        }
    }

    static class HumanFactoryMaker {

        Human human;

        public HumanFactoryMaker(Human human) {
            setPrototype(human);
        }

        public void setPrototype(Human human) {
            this.human = human;

        }

        Human makecopy() {
            return (Human) human.copy();
        }

    }
}
