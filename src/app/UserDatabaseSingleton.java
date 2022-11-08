package app;

import java.util.HashMap;
import java.util.Map;

public class UserDatabaseSingleton {
    private static UserDatabaseSingleton instance;

    private Map<String, User> userMap;

    private UserDatabaseSingleton() {
        userMap = new HashMap<>();
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public static UserDatabaseSingleton getInstance() {
        if(instance == null) {
            instance = new UserDatabaseSingleton();
        }
        return instance;
    }
}
