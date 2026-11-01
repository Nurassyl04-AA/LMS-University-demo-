package com.aitu.lms.observer;
import java.util.concurrent.atomic.AtomicInteger;
public final class RecordingListener implements Observer { private final AtomicInteger count=new AtomicInteger(); private final String name; public RecordingListener(String name){this.name=name;} public void onEvent(Event e){count.incrementAndGet();} public int count(){return count.get();} public String name(){return name;} }
