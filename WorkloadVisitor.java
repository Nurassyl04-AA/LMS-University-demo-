package edu.lms.visitor;

import edu.lms.tree.*;

public class WorkloadVisitor implements Visitor<Integer> {
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
        return course.getItems().stream().mapToInt(item -> item.accept(this)).sum();
    }

    @Override public Integer visit(Lecture lecture) { return lecture.getHours(); }
    @Override public Integer visit(Lab lab) { return lab.getHours(); }
    @Override public Integer visit(Exam exam) { return 2; }
}
