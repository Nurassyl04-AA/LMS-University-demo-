package com.aitu.lms.observer;
public interface Subject { void subscribe(EventType type, Observer observer); void unsubscribe(EventType type, Observer observer); void publish(Event event); }
