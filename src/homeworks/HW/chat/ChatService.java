package homeworks.HW.chat;

import java.util.*;

public class ChatService {

    private Map<User, ArrayList<Message>> sourceOfMessage;

    private List<User> userList;

    public ChatService() {
        sourceOfMessage = new HashMap<>();

        userList = new ArrayList<>();
    }

    public void write(User sender, User receiver, String message) {

        if (!isUserExist(sender, receiver)) {
            System.out.println("One of user is not registered");
            return;
        }

        Message messageDetails =
                new Message(message, sender.getName(), receiver.getName(), new Date());

        if (sourceOfMessage.containsKey(sender) &&
                sourceOfMessage.containsKey(receiver)) {

            sourceOfMessage.get(sender).add(messageDetails);

            sourceOfMessage.get(receiver).add(messageDetails);

        } else {

            ArrayList<Message> senderList = new ArrayList<>();

            senderList.add(messageDetails);

            ArrayList<Message> receiverList = new ArrayList<>();

            receiverList.add(messageDetails);

            sourceOfMessage.put(sender, senderList);

            sourceOfMessage.put(receiver, receiverList);
        }
    }

    private boolean isUserExist(User sender, User receiver) {

        return userList.contains(sender) && userList.contains(receiver);
    }

    public void showHistory(User sender, User receiver) {

        if (!isUserExist(sender, receiver)) {
            System.out.println("One of user is not registered");
            return;
        }

        sourceOfMessage.get(sender).stream()
                .filter(k -> {
                            String to = k.getTo();
                            String from = k.getFrom();
                            String senderName = sender.getName();
                            return ((to.contains(senderName) &&
                                    from.contains(receiver.getName())) ||
                                    (to.contains(receiver.getName()) &&
                                            from.contains(senderName)));
                        }
                )
                .forEach(k -> System.out.println(k.getMessage()));
    }

    public void register(User user) {
        userList.add(user);
    }
}
