package app;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Subject subject;
    private List<User> following;
    private List<Observer> observers;
    private String userId;

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

    public void followUser(User otherUser) {
        Observer observer = new ConcreteObserver(this.getUserId(), otherUser.getSubject());
        observers.add(observer);
        if(!otherUser.equals(this)) {
            following.add(otherUser);
        }
    }
}
