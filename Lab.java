package com.aitu.lms.domain;
import com.aitu.lms.visitor.*;
public final class Lab implements Element { private final String name; private final int workload; public Lab(String name,int workload){this.name=name;this.workload=workload;} public String name(){return name;} public int workload(){return workload;} public <R> R accept(Visitor<R> v){return v.visitLab(this);} }
