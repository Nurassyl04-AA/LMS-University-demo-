package edu.lms.runtime;

import edu.lms.observer.ConcurrentSubject;
import edu.lms.observer.Event;
import edu.lms.observer.EventType;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StressTest {

    @Test
    void stressTestConcurrentSubject() throws InterruptedException {
        ConcurrentSubject subject = new ConcurrentSubject();
        AtomicInteger count = new AtomicInteger(0);

        subject.subscribe(EventType.GRADE_POSTED, event -> count.incrementAndGet());

        int threads = 4;
        int eventsPerThread = 1000;
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        for (int i = 0; i < threads; i++) {
            executor.submit(() -> {
                for (int j = 0; j < eventsPerThread; j++) {
                    subject.notifyListeners(new Event(EventType.GRADE_POSTED, "Test"));
                }
            });
        }

        executor.shutdown();
        assertTrue(executor.awaitTermination(5, TimeUnit.SECONDS));
        assertEquals(threads * eventsPerThread, count.get());
    }
}
