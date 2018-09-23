package lessons.patterns.adapter.via_inheritance;

public interface MicroUsb {
    void readMicroUsb();
    void writeMicroUsb();
}

/*Structural pattern*/
class Adapter extends MiniUsb implements MicroUsb {
    @Override
    public void readMicroUsb() {
        readMiniUsb();
    }

    @Override
    public void writeMicroUsb() {
        writeMiniUsb();
    }
}
