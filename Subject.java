package edu.lms.observer;

public interface Subject {
    void subscribe(EventType type, Observer observer);
    void unsubscribe(EventType type, Observer observer);
    void notifyListeners(Event event);
}
