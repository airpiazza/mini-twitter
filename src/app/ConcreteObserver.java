package app;

public class ConcreteObserver implements Observer {
    private String latestTweet;

    private String userId;

    private Subject following;

    public ConcreteObserver(String userId, Subject otherUser) {
        this.following = otherUser;

        this.userId = userId;

        otherUser.attach(this);
    }


    public String getUserId() {
        return userId;
    }

    @Override
    public void update(String latestTweet) {
        this.latestTweet = latestTweet;

        User thisUser = UserDatabaseSingleton.getInstance().getUserMap().get(this.getUserId());
        thisUser.getNewsFeedListView().getItems().add(this.latestTweet);
    }
}
