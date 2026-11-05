package edu.lms.runtime;

import edu.lms.observer.ConcurrentSubject;
import edu.lms.observer.EventType;
import edu.lms.observer.Subject;
import edu.lms.listener.AdvisorNotifier;
import edu.lms.listener.StudentNotifier;
import edu.lms.tree.*;

public class CompositionRoot {
    private final Subject subject;
    private final Faculty faculty;

    public CompositionRoot() {
        this.subject = new ConcurrentSubject();

        this.faculty = new Faculty("Faculty of Information Technology");
        Program program = new Program("Software Engineering (SE-2532)");
        Course course = new Course("Object-Oriented Programming", 5);

        course.addItem(new Lecture("Design Patterns", 4));
        course.addItem(new Lab("Lab Work", 6));
        course.addItem(new Exam("Final Exam", 40));

        program.addChild(course);
        faculty.addChild(program);

        subject.subscribe(EventType.DEADLINE_APPROACHING, new AdvisorNotifier(faculty));
        subject.subscribe(EventType.GRADE_POSTED, new StudentNotifier());
    }

    public Subject getSubject() { return subject; }
    public Faculty getFaculty() { return faculty; }
}
