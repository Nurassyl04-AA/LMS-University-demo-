package edu.lms.visitor;

import edu.lms.tree.*;

public class StatisticsVisitor implements Visitor<String> {
    private int courses = 0;
    private int lectures = 0;
    private int labs = 0;
    private int exams = 0;

    @Override
    public String visit(Faculty faculty) {
        faculty.getChildren().forEach(c -> c.accept(this));
        return getSummary();
    }

    @Override
    public String visit(Program program) {
        program.getChildren().forEach(c -> c.accept(this));
        return getSummary();
    }

    @Override
    public String visit(Course course) {
        courses++;
        course.getItems().forEach(i -> i.accept(this));
        return getSummary();
    }

    @Override
    public String visit(Lecture lecture) {
        lectures++;
        return getSummary();
    }

    @Override
    public String visit(Lab lab) {
        labs++;
        return getSummary();
    }

    @Override
    public String visit(Exam exam) {
        exams++;
        return getSummary();
    }

    public String getSummary() {
        return String.format("Courses: %d, Lectures: %d, Labs: %d, Exams: %d", courses, lectures, labs, exams);
    }
}
