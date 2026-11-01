package com.aitu.lms.visitor;
import com.aitu.lms.domain.*;
public interface Visitor<R>{ R visitFaculty(Faculty x); R visitProgram(Program x); R visitCourse(Course x); R visitLecture(Lecture x); R visitLab(Lab x); R visitExam(Exam x); R visitStudent(Student x); }
