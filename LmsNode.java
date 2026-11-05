package edu.lms.tree;

public interface LmsNode {
    String getName();
    <R> R accept(Visitor<R> visitor);
}
