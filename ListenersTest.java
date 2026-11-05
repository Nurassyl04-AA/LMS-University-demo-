package edu.lms.listener;

import edu.lms.observer.Event;
import edu.lms.observer.EventType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ListenersTest {

    @Test
    void testStudentNotifier() {
        StudentNotifier notifier = new StudentNotifier();
        assertDoesNotThrow(() -> notifier.onEvent(new Event(EventType.GRADE_POSTED, "Grade A")));
    }
}
