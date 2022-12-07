package app;

public class Group {
    private String groupId;
    private long creationTime;

    public Group(String groupId) {
        this.groupId = groupId;
        this.creationTime = System.currentTimeMillis();
    }

    public String getGroupId() {
        return groupId;
    }

    public long getCreationTime() {
        return creationTime;
    }
}
