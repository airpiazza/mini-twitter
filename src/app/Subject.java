package app;

public interface Subject {
    public void attach(Observer follower);
    public void notifyObservers();
}
