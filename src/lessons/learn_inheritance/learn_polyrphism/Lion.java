package lessons.learn_inheritance.learn_polyrphism;

/**
 * Created by nazar on 3/11/2017.
 */
public class Lion extends Animal {
    @Override
    public void say() {
        System.out.println("R-r-r" + count);
    }
}
