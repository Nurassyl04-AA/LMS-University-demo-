package com.aitu.lms.observer;
import java.time.Instant;
public final class DeadlineSource { private final Subject subject; public DeadlineSource(Subject subject){this.subject=subject;} public void deadlineUpdated(String studentId,String message){subject.publish(new Event(EventType.DEADLINE_UPDATED,studentId,message,Instant.now()));} }
