package lessons.patterns.adapter.via_aggregation;

import lessons.patterns.adapter.via_inheritance.MicroUsb;
import lessons.patterns.adapter.via_inheritance.MiniUsb;

public class AdapterUsb implements MicroUsb {

    private MiniUsb miniUsb;

    public AdapterUsb() {
        miniUsb = new MiniUsb();
    }

    @Override
    public void readMicroUsb() {
        miniUsb.readMiniUsb();
    }

    @Override
    public void writeMicroUsb() {
        miniUsb.writeMiniUsb();

    }
}
