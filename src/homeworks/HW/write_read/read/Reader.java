package homeworks.HW.write_read.read;


public abstract class Reader implements Readable {

    public String modifyText(String text) {
        String oldPattern = "I'm ready for writting to file";
        String newPattern = "I'm from file";

        return text.replace(oldPattern, newPattern);
    }
}
