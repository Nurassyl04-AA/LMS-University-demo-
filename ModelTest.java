package edu.lms.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelTest {

    @Test
    void testStudentAndGpa() {
        Student student = new Student("1", "Adilbek");
        assertEquals("Adilbek", student.getName());
        assertEquals(4.0, GradeScale.toGpa(95));
    }
}
