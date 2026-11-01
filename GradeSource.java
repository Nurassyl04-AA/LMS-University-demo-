package com.aitu.lms.observer;
import java.time.Instant;
public final class GradeSource { private final Subject subject; public GradeSource(Subject subject){this.subject=subject;} public void gradeChanged(String studentId,String message){subject.publish(new Event(EventType.GRADE_CHANGED,studentId,message,Instant.now()));} }
