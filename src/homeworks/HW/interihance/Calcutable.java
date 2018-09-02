package homeworks.HW.interihance;

/**
 * Created by nazar123 on 30.01.2018.
 */
public interface Calcutable {

    int calculateSquare();

    default void print() {
        Class aClass = this.getClass();

        System.out.println("The square of " +aClass.getSimpleName()+" is "+ calculateSquare());
    }
}
