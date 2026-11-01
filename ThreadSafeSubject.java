package com.aitu.lms.observer;
import java.util.*; import java.util.concurrent.*; import java.util.concurrent.atomic.AtomicBoolean;
public final class ThreadSafeSubject implements Subject, AutoCloseable {
 private final ConcurrentMap<EventType, CopyOnWriteArrayList<Observer>> listeners = new ConcurrentHashMap<>();
 private final ExecutorService executor; private final AtomicBoolean closed = new AtomicBoolean();
 public ThreadSafeSubject(int threadCount) { if(threadCount<1) throw new IllegalArgumentException("threadCount must be positive"); executor=Executors.newFixedThreadPool(threadCount); }
 public void subscribe(EventType t, Observer o){ requireOpen(); listeners.computeIfAbsent(t,k->new CopyOnWriteArrayList<>()).addIfAbsent(o); }
 public void unsubscribe(EventType t, Observer o){ var list=listeners.get(t); if(list!=null) list.remove(o); }
 public void publish(Event e){ requireOpen(); var list=listeners.getOrDefault(e.type(), new CopyOnWriteArrayList<>()); for(Observer o:list) executor.submit(() -> o.onEvent(e)); }
 private void requireOpen(){ if(closed.get()) throw new IllegalStateException("Subject is closed"); }
 public void shutdownGracefully(){ if(closed.compareAndSet(false,true)){ executor.shutdown(); try { if(!executor.awaitTermination(30,TimeUnit.SECONDS)) executor.shutdownNow(); } catch(InterruptedException x){ executor.shutdownNow(); Thread.currentThread().interrupt(); } } }
 public void close(){ shutdownGracefully(); }
}
