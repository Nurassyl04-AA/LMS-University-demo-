package edu.lms.visitor;

import edu.lms.tree.Faculty;
import edu.lms.tree.Program;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonExportVisitorTest {

    @Test
    void testJsonExport() {
        Faculty faculty = new Faculty("FIT");
        faculty.addChild(new Program("SE"));

        JsonExportVisitor visitor = new JsonExportVisitor();
        String json = faculty.accept(visitor);

        assertTrue(json.contains("faculty"));
        assertTrue(json.contains("FIT"));
    }
}
