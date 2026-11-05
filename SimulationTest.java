package edu.lms.runtime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimulationTest {

    @Test
    void testCompositionRoot() {
        CompositionRoot root = new CompositionRoot();
        assertNotNull(root.getFaculty());
        assertNotNull(root.getSubject());
    }
}
