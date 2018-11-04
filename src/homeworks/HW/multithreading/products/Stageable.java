package homeworks.HW.multithreading.products;

import java.io.IOException;

public interface Stageable {
    void action(final String workerName) throws IOException;
}
