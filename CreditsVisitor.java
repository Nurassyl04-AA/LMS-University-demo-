package edu.lms.visitor;

import edu.lms.tree.*;

public class CreditsVisitor implements Visitor<Integer> {
    @Override
    public Integer visit(Faculty faculty) {
        return faculty.getChildren().stream().mapToInt(c -> c.accept(this)).sum();
    }

    @Override
    public Integer visit(Program program) {
        return program.getChildren().stream().mapToInt(c -> c.accept(this)).sum();
    }

    @Override
    public Integer visit(Course course) {
        return course.getCredits();
    }

    @Override public Integer visit(Lecture lecture) { return 0; }
    @Override public Integer visit(Lab lab) { return 0; }
    @Override public Integer visit(Exam exam) { return 0; }
}
