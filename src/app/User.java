package app;

import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class User {
    private ConcreteSubject subject;

    private List<String> followers;

    private List<String> following;

    private List<Observer> observers;

    private String userId;

    private ListView<String> newsFeedListView;

    private List<String> newsFeedList;

    public User(String userId) {
        this.subject = new ConcreteSubject(userId);
        followers = new ArrayList<>();
        following = new ArrayList<>();
        observers = new ArrayList<>();
        newsFeedList = new ArrayList<>();
        this.userId = userId;

        this.followUser(this);
    }

    public Subject getSubject() {
        return subject;
    }

    public String getUserId() {
        return userId;
    }

    public List<String> getFollowers() {
        return followers;
    }

    public List<String> getFollowing() {
        return following;
    }

    public ListView<String> getNewsFeedListView() {
        return newsFeedListView;
    }

    public void setNewsFeedListView(ListView<String> newsFeedListView) {
        this.newsFeedListView = newsFeedListView;
        this.setNewsFeedList(this.newsFeedListView.getItems());
    }

    public void setNewsFeedList(List<String> newsFeedList) {
        this.newsFeedList = newsFeedList;
    }

    public void followUser(User otherUser) {
        Observer observer = new ConcreteObserver(this.getUserId(), otherUser.getSubject());
        otherUser.getFollowers().add(this.getUserId());
        observers.add(observer);
        if(!otherUser.equals(this)) {
            following.add(otherUser.getUserId());
        }
    }

    public void postTweet(String newTweet) {
        this.subject.setLatestTweet(newTweet);
    }
}
