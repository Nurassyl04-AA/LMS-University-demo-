package edu.lms.tree;

public class Lecture implements LmsNode {
    private final String name;
    private final int hours;

    public Lecture(String name, int hours) {
        this.name = name;
        this.hours = hours;
    }

    public int getHours() { return hours; }

    @Override
    public String getName() { return name; }

    @Override
    public <R> R accept(Visitor<R> visitor) { return visitor.visit(this); }
}
