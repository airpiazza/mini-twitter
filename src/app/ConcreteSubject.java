package app;

import java.util.ArrayList;
import java.util.List;

// concrete subject that implements subject
public class ConcreteSubject implements Subject{
    private String userId;
    private String latestTweet;
    private List<Observer> followers;

    // keep track of user ID and initialize list of observers
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
        this.latestTweet = latestTweet;
        notifyObservers();
    }

    // add new observer to observer list
    @Override
    public void attach(Observer newFollower) {
        followers.add(newFollower);
    }

    // call each observer's update method with this subject's latest tweet
    @Override
    public void notifyObservers() {
        for (Observer follower:
             followers) {
            follower.update(this.getLatestTweet());
        }
    }
}
