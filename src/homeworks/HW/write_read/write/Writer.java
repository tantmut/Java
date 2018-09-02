package homeworks.HW.write_read.write;

public abstract class Writer implements Writable {

    public String modifyText(String text) {
        return "I'm ready for writting to file " + text;
    }

}
