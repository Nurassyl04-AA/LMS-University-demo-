package edu.lms.visitor;

import edu.lms.tree.Course;
import edu.lms.tree.Lecture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkloadVisitorTest {

    @Test
    void testWorkload() {
        Course course = new Course("Java", 5);
        course.addItem(new Lecture("OOP", 4));

        WorkloadVisitor visitor = new WorkloadVisitor();
        assertEquals(4, (int) course.accept(visitor));
    }
}
