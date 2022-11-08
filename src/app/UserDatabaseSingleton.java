package app;

import java.util.HashMap;
import java.util.Map;

public class UserDatabaseSingleton {
    private static UserDatabaseSingleton instance;

    public Map<String, User> getUserMap() {
        return userMap;
    }

    private Map<String, User> userMap;

    private UserDatabaseSingleton() {
        userMap = new HashMap<>();
    }

    public static UserDatabaseSingleton getInstance() {
        if(instance == null) {
            instance = new UserDatabaseSingleton();
        }
        return instance;
    }
}
