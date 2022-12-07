package app;

// concrete observer that implements Observer
public class ConcreteObserver implements Observer {
    private String latestTweet;

    private String userId;

    private Subject following;

    // this concrete observer subscribes to the subject while keeping track of subject and user ID
    public ConcreteObserver(String userId, Subject otherUser) {
        this.following = otherUser;

        this.userId = userId;

        otherUser.attach(this);
    }


    public String getUserId() {
        return userId;
    }

    // adds latest tweet from this subject to the user's newsfeed
    @Override
    public void update(String latestTweet) {
        this.latestTweet = latestTweet;

        User thisUser = UserDatabaseSingleton.getInstance().getUserMap().get(this.getUserId());
        thisUser.getNewsFeedListView().getItems().add(this.latestTweet);
        thisUser.setLastUpdateTime(System.currentTimeMillis());
        System.out.println(thisUser.getUserId() + " last updated at " + thisUser.getLastUpdateTime());
        UserDatabaseSingleton.getInstance().getLastUpdatedUserList().add(thisUser);
        MessageDatabaseSingleton.getInstance().getMessageList().add(this.latestTweet);
    }
}
