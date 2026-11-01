package com.aitu.lms.domain;
import com.aitu.lms.visitor.*; import java.util.*;
public final class Faculty implements Element { private final String name; private final List<Element> children=new ArrayList<>(); public Faculty(String name){this.name=name;} public void add(Element e){children.add(e);} public String name(){return name;} public List<Element> children(){return List.copyOf(children);} public <R> R accept(Visitor<R> v){return v.visitFaculty(this);} }
