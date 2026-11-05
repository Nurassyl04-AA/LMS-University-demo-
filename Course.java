package edu.lms.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course implements LmsNode {
    private final String name;
    private final int credits;
    private final List<LmsNode> items = new ArrayList<>();

    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public void addItem(LmsNode item) {
        items.add(item);
    }

    public List<LmsNode> getItems() {
        return Collections.unmodifiableList(items);
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String getName() { return name; }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
