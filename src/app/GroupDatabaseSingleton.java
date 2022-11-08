package app;

import java.util.ArrayList;
import java.util.List;

public class GroupDatabaseSingleton {
    private static GroupDatabaseSingleton instance;

    private List<String> groupList;

    private GroupDatabaseSingleton() {
        groupList = new ArrayList<>();
    }

    public List<String> getGroupList() {
        return groupList;
    }

    public static GroupDatabaseSingleton getInstance() {
        if(instance == null) {
            instance = new GroupDatabaseSingleton();
        }
        return instance;
    }
}
