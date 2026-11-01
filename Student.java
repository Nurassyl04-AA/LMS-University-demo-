package com.aitu.lms.domain;
import com.aitu.lms.visitor.*;
public final class Student implements Element { private final String id; private final String name; private final double gpa; public Student(String id,String name,double gpa){this.id=id;this.name=name;this.gpa=gpa;} public String id(){return id;} public String name(){return name;} public double gpa(){return gpa;} public <R> R accept(Visitor<R> v){return v.visitStudent(this);} }
