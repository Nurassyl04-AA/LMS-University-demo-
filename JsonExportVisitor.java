package edu.lms.visitor;

import edu.lms.tree.*;
import java.util.stream.Collectors;

public class JsonExportVisitor implements Visitor<String> {
    @Override
    public String visit(Faculty faculty) {
        String children = faculty.getChildren().stream().map(c -> c.accept(this)).collect(Collectors.joining(","));
        return String.format("{\"faculty\":\"%s\",\"children\":[%s]}", faculty.getName(), children);
    }

    @Override
    public String visit(Program program) {
        String children = program.getChildren().stream().map(c -> c.accept(this)).collect(Collectors.joining(","));
        return String.format("{\"program\":\"%s\",\"courses\":[%s]}", program.getName(), children);
    }

    @Override
    public String visit(Course course) {
        String items = course.getItems().stream().map(i -> i.accept(this)).collect(Collectors.joining(","));
        return String.format("{\"course\":\"%s\",\"credits\":%d,\"items\":[%s]}", course.getName(), course.getCredits(), items);
    }

    @Override
    public String visit(Lecture lecture) {
        return String.format("{\"lecture\":\"%s\",\"hours\":%d}", lecture.getName(), lecture.getHours());
    }

    @Override
    public String visit(Lab lab) {
        return String.format("{\"lab\":\"%s\",\"hours\":%d}", lab.getName(), lab.getHours());
    }

    @Override
    public String visit(Exam exam) {
        return String.format("{\"exam\":\"%s\",\"weight\":%d}", exam.getName(), exam.getWeight());
    }
}
