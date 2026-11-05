package edu.lms.listener;

import edu.lms.observer.Event;
import edu.lms.observer.Observer;
import edu.lms.tree.LmsNode;
import edu.lms.visitor.WorkloadVisitor;

public class AdvisorNotifier implements Observer {
    private final LmsNode tree;

    public AdvisorNotifier(LmsNode tree) {
        this.tree = tree;
    }

    @Override
    public void onEvent(Event event) {
        WorkloadVisitor visitor = new WorkloadVisitor();
        int hours = tree.accept(visitor);
        System.out.println("[ADVISOR] Event: " + event.getMessage() + " | Workload: " + hours + " hours");
    }
}
