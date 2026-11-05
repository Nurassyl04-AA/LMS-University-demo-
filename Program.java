package edu.lms.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program implements LmsNode {
    private final String name;
    private final List<LmsNode> children = new ArrayList<>();

    public Program(String name) {
        this.name = name;
    }

    public void addChild(LmsNode child) {
        children.add(child);
    }

    public List<LmsNode> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public String getName() { return name; }

    @Override
    public <R> R accept(Visitor<R> visitor) {
        return visitor.visit(this);
    }
}
