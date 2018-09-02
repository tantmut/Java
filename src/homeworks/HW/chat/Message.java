package homeworks.HW.chat;

import java.util.Date;

public class Message {

    private String text;
    private String from;
    private String to;
    private Date date;//LocalDate

    public Message(String text, String from, String to, Date date) {
        this.text = text;
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String getMessage(){
        return "Sent date: "+ getDate()+" from user: "+getFrom() +":"+ getText() + "\n";
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
