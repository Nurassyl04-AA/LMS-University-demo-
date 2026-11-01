package com.aitu.lms.observer;
import java.util.concurrent.ConcurrentHashMap; import java.util.concurrent.atomic.AtomicInteger;
public final class GpaTracker implements Observer { private final ConcurrentHashMap<String,AtomicInteger> changes=new ConcurrentHashMap<>(); public void onEvent(Event e){changes.computeIfAbsent(e.studentId(),k->new AtomicInteger()).incrementAndGet();} public int changesFor(String id){return changes.getOrDefault(id,new AtomicInteger()).get();} }
