package com.aitu.lms.observer;
import java.time.Instant;
public record Event(EventType type, String studentId, String message, Instant timestamp) {
    public Event { if (type == null || studentId == null || message == null || timestamp == null) throw new IllegalArgumentException("Event fields cannot be null"); }
}
