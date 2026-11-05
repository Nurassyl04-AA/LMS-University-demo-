package edu.lms.model;

import java.util.ArrayList;
import java.util.List;

public class CourseCatalog {
    private final List<String> courses = new ArrayList<>();

    public void addCourse(String courseName) {
        courses.add(courseName);
    }

    public List<String> getCourses() {
        return courses;
    }
}
