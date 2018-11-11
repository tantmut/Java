package homeworks.HW.chat;

public class Main {
    public static void main(String[] args) {

        User ivan = new User("Ivan", "Mad", 23);
        User igor = new User("Igor", "Bil", 25);
        User ira = new User("Ira", "Clau", 23);

        ChatService chat = new ChatService();
        chat.register(ivan);
        chat.register(igor);
//        chat.register(ira);

        chat.write(ivan, igor, "Hello");
        chat.write(ivan, igor, "How are u");
        chat.write(ivan, ira, "Hello");

        chat.write(igor, ivan, "Hi");
        chat.write(igor, ivan, "I am fine. And u?");
        chat.write(ira, ivan, "Good morning");

//        chat.showHistory(igor, ivan);
        chat.write(ivan, igor, "Thanks. I am fine too");

//        chat.showHistory(ivan, igor);
//        chat.showHistory(ivan, igor);

        chat.showHistory(igor, ira);


    }
}