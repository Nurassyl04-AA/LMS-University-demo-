package edu.lms.observer;

public class Event {
    private final EventType type;
    private final String message;

    public Event(EventType type, String message) {
        this.type = type;
        this.message = message;
    }

    public EventType getType() { return type; }
    public String getMessage() { return message; }
}
