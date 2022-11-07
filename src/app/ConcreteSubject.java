package app;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject{
    private String userId;
    private String latestTweet;
    private List<Observer> followers;

    public ConcreteSubject(String userId) {
        this.userId = userId;
        followers = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getLatestTweet() {
        return latestTweet;
    }

    public void setLatestTweet(String latestTweet) {
        this.latestTweet = this.getUserId() + ": " + latestTweet;
        notifyObservers();
    }

    @Override
    public void attach(Observer newFollower) {
        followers.add(newFollower);
    }

    @Override
    public void notifyObservers() {
        for (Observer follower:
             followers) {
            follower.update(this.getLatestTweet());
        }
    }
}
