package com.aitu.lms.domain;
import com.aitu.lms.visitor.Element; import com.aitu.lms.visitor.Visitor;
import java.util.*;
public final class Course implements Element { private final String name; private final int credits; private final List<Element> elements=new ArrayList<>(); public Course(String name,int credits){this.name=name;this.credits=credits;} public void add(Element e){elements.add(e);} public String name(){return name;} public int credits(){return credits;} public List<Element> children(){return List.copyOf(elements);} public <R> R accept(Visitor<R> v){return v.visitCourse(this);} }
