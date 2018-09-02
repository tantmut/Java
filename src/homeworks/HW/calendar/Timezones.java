package homeworks.HW.calendar;

public enum Timezones {
    RANKIN_INLET("America/Rankin_Inlet"),
    SAO_TOME("Africa/Sao_Tome"),
    RIYADH("Asia/Riyadh"),
    CHRISTMAS("Indian/Christmas");

    private String text;

    Timezones(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
