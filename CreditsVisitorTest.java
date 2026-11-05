package edu.lms.visitor;

import edu.lms.tree.Course;
import edu.lms.tree.Faculty;
import edu.lms.tree.Program;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditsVisitorTest {

    @Test
    void testCredits() {
        Faculty faculty = new Faculty("FIT");
        Program program = new Program("SE");
        program.addChild(new Course("Java", 5));
        faculty.addChild(program);

        CreditsVisitor visitor = new CreditsVisitor();
        assertEquals(5, (int) faculty.accept(visitor));
    }
}
