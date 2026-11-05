package edu.lms.tree;

public interface Visitor<R> {
    R visit(Faculty faculty);
    R visit(Program program);
    R visit(Course course);
    R visit(Lecture lecture);
    R visit(Lab lab);
    R visit(Exam exam);
}
