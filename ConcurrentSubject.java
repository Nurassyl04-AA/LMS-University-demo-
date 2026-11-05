package edu.lms.observer;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentSubject implements Subject {
    private final ConcurrentHashMap<EventType, Set<Observer>> listeners = new ConcurrentHashMap<>();

    @Override
    public void subscribe(EventType type, Observer observer) {
        listeners.computeIfAbsent(type, k -> new CopyOnWriteArraySet<>()).add(observer);
    }

    @Override
    public void unsubscribe(EventType type, Observer observer) {
        Set<Observer> set = listeners.get(type);
        if (set != null) {
            set.remove(observer);
        }
    }

    @Override
    public void notifyListeners(Event event) {
        Set<Observer> set = listeners.get(event.getType());
        if (set != null) {
            for (Observer observer : set) {
                observer.onEvent(event);
            }
        }
    }
}
