package edu.lms.listener;

import edu.lms.observer.Event;
import edu.lms.observer.Observer;

public class StudentNotifier implements Observer {
    @Override
    public void onEvent(Event event) {
        System.out.println("[STUDENT] " + event.getType() + ": " + event.getMessage());
    }
}
