package edu.lms.runtime;

import edu.lms.observer.Event;
import edu.lms.observer.EventType;
import edu.lms.visitor.CreditsVisitor;
import edu.lms.visitor.JsonExportVisitor;
import edu.lms.visitor.StatisticsVisitor;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   Starting University LMS System (Topic 5)      ");
        System.out.println("=================================================\n");

        CompositionRoot root = new CompositionRoot();

        System.out.println("1. Total Credits Calculation:");
        CreditsVisitor creditsVisitor = new CreditsVisitor();
        System.out.println("   ECTS Credits: " + root.getFaculty().accept(creditsVisitor));

        System.out.println("\n2. Tree Statistics:");
        StatisticsVisitor statsVisitor = new StatisticsVisitor();
        root.getFaculty().accept(statsVisitor);
        System.out.println("   Summary: " + statsVisitor.getSummary());

        System.out.println("\n3. JSON Export:");
        JsonExportVisitor jsonVisitor = new JsonExportVisitor();
        System.out.println("   " + root.getFaculty().accept(jsonVisitor));

        System.out.println("\n4. Triggering Event (Observer -> Integration -> Visitor):");
        root.getSubject().notifyListeners(new Event(EventType.DEADLINE_APPROACHING, "Assignment 6 Deadline!"));

        System.out.println("\n=================================================");
        System.out.println("   Finished Successfully!                        ");
        System.out.println("=================================================");
    }
}
