package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// singleton for keeping track of all the users in Mini Twitter
public class UserDatabaseSingleton {
    private static UserDatabaseSingleton instance;

    private Map<String, User> userMap;

    private ArrayList<String> userIds = new ArrayList<>();

    private ArrayList<User> lastUpdatedUserList = new ArrayList<>();

    private UserDatabaseSingleton() {
        userMap = new HashMap<>();
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public ArrayList<String> getUserIds() {
        return userIds;
    }

    public ArrayList<User> getLastUpdatedUserList() {
        return lastUpdatedUserList;
    }

    public static UserDatabaseSingleton getInstance() {
        if(instance == null) {
            instance = new UserDatabaseSingleton();
        }
        return instance;
    }
}
