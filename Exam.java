package edu.lms.tree;

public class Exam implements LmsNode {
    private final String name;
    private final int weight;

    public Exam(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() { return weight; }

    @Override
    public String getName() { return name; }

    @Override
    public <R> R accept(Visitor<R> visitor) { return visitor.visit(this); }
}
