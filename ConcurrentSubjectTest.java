package edu.lms.observer;

import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConcurrentSubjectTest {

    @Test
    void testSubscribeAndNotify() {
        ConcurrentSubject subject = new ConcurrentSubject();
        AtomicBoolean notified = new AtomicBoolean(false);

        subject.subscribe(EventType.GRADE_POSTED, event -> notified.set(true));
        subject.notifyListeners(new Event(EventType.GRADE_POSTED, "Test"));

        assertTrue(notified.get());
    }

    @Test
    void testUnsubscribe() {
        ConcurrentSubject subject = new ConcurrentSubject();
        AtomicBoolean notified = new AtomicBoolean(false);

        Observer observer = event -> notified.set(true);
        subject.subscribe(EventType.GRADE_POSTED, observer);
        subject.unsubscribe(EventType.GRADE_POSTED, observer);

        subject.notifyListeners(new Event(EventType.GRADE_POSTED, "Test"));
        assertFalse(notified.get());
    }
}
