package edu.lms.event;

import edu.lms.observer.Event;
import edu.lms.observer.EventType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventsTest {

    @Test
    void testEvent() {
        Event event = new Event(EventType.DEADLINE_APPROACHING, "Message");
        assertEquals(EventType.DEADLINE_APPROACHING, event.getType());
        assertEquals("Message", event.getMessage());
    }
}
