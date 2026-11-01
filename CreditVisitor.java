package com.aitu.lms.visitor;
import com.aitu.lms.domain.*;
public final class CreditVisitor implements Visitor<Integer>{ public Integer visitFaculty(Faculty x){int n=0;for(Element e:x.children())n+=e.accept(this);return n;} public Integer visitProgram(Program x){int n=0;for(Element e:x.children())n+=e.accept(this);return n;} public Integer visitCourse(Course x){return x.credits();} public Integer visitLecture(Lecture x){return 0;} public Integer visitLab(Lab x){return 0;} public Integer visitExam(Exam x){return 0;} public Integer visitStudent(Student x){return 0;} }
