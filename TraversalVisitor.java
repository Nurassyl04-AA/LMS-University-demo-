package com.aitu.lms.visitor;
import com.aitu.lms.domain.*;
public abstract class TraversalVisitor<R> implements Visitor<R>{ public R visitFaculty(Faculty x){for(Element e:x.children())e.accept(this);return result();} public R visitProgram(Program x){for(Element e:x.children())e.accept(this);return result();} public R visitCourse(Course x){for(Element e:x.children())e.accept(this);return result();} protected abstract R result(); public abstract R visitLecture(Lecture x); public abstract R visitLab(Lab x); public abstract R visitExam(Exam x); public abstract R visitStudent(Student x); }
