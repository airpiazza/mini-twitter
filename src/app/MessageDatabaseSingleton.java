package app;

import java.util.ArrayList;
import java.util.List;

// singleton to keep track of the total number of messages in all the users' news feeds
public class MessageDatabaseSingleton {
    private static MessageDatabaseSingleton instance;

    private List<String> messageList;

    public MessageDatabaseSingleton() {
        this.messageList = new ArrayList<>();
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public static MessageDatabaseSingleton getInstance() {
        if(instance == null) {
            instance = new MessageDatabaseSingleton();
        }
        return instance;
    }
}
