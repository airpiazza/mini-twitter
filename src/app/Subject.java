package app;

// Subject interface for the observer pattern in Mini Twitter
public interface Subject {
    public void attach(Observer follower);
    public void notifyObservers();
}
