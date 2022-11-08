package app;

import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class User {
    private ConcreteSubject subject;

    private List<User> following;

    private List<Observer> observers;

    private String userId;

    private ListView<String> newsFeedListView;

    public User(String userId) {
        this.subject = new ConcreteSubject(userId);
        following = new ArrayList<>();
        observers = new ArrayList<>();
        this.userId = userId;

        this.followUser(this);
    }

    public Subject getSubject() {
        return subject;
    }

    public String getUserId() {
        return userId;
    }

    public List<User> getFollowing() {
        return following;
    }

    public ListView<String> getNewsFeedListView() {
        return newsFeedListView;
    }

    public void setNewsFeedListView(ListView<String> newsFeedListView) {
        this.newsFeedListView = newsFeedListView;
    }

    public void followUser(User otherUser) {
        Observer observer = new ConcreteObserver(this.getUserId(), otherUser.getSubject());
        observers.add(observer);
        if(!otherUser.equals(this)) {
            following.add(otherUser);
        }
    }

    public void postTweet(String newTweet) {
        this.subject.setLatestTweet(newTweet);
    }
}
