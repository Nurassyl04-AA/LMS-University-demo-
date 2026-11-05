package edu.lms.visitor;

import edu.lms.tree.Course;
import edu.lms.tree.Lecture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatisticsVisitorTest {

    @Test
    void testStatistics() {
        Course course = new Course("Java", 5);
        course.addItem(new Lecture("OOP", 4));

        StatisticsVisitor visitor = new StatisticsVisitor();
        course.accept(visitor);

        assertTrue(visitor.getSummary().contains("Courses: 1"));
    }
}
