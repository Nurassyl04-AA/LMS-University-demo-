# Assignment 6 — University LMS (Variant 5)

Java 17 implementation of the Observer + Visitor assignment for the **University LMS** topic.

## Requirements covered
- **Observer:** grades and deadlines are two sources. Events are immutable records and listeners subscribe by event type. The registry uses `ConcurrentHashMap` + `CopyOnWriteArrayList`; listeners may subscribe/unsubscribe at runtime, including from inside their own handler.
- **5+ listeners:** student notifier, parent notifier, advisor notifier, GPA tracker, deadline tracker, plus an aggregation listener.
- **Chain:** `AggregatingListener` is both an observer and a subject and republishes aggregated GPA events.
- **Push model:** the complete immutable event is pushed to listeners. This keeps listeners independent of the subject's internal state and makes asynchronous delivery straightforward.
- **Visitor:** stable tree `Faculty → Program → Course → leaf/student` with 3 levels and leaf types `Lecture`, `Lab`, `Exam`, `Student`.
- **4 visitors:** `CreditVisitor`, `WorkloadVisitor`, `StudentFilterVisitor`, `JsonExportVisitor`.
- **Double dispatch:** each element implements `accept(visitor)` and calls its concrete `visitX` method.
- **Integration:** an `ALERT` triggers `AlertInspectionListener`, which runs the four visitor operations on the related subtree and publishes an `INSPECTION_REPORT` event.
- **Concurrency:** configurable `ExecutorService`; thread-safe registry/shared counters; graceful shutdown.
- **Tests:** 16 JUnit 5 tests, including 4 producers × 1,000 events with exact expected count 4,000.
- **Clean Code:** constructor injection, one application composition root, no `java.util.Observable`, no event-bus library.

## Run
Requirements: JDK 17 and Maven.

```bash
mvn test
mvn -q exec:java -Dexec.mainClass=com.aitu.lms.app.UniversityLms
```

The second command requires the Maven Exec plugin if you choose to use it; alternatively run `com.aitu.lms.app.UniversityLms` from IntelliJ IDEA.

## Visitor traversal decision
The visitor performs traversal for the composite nodes. This keeps element classes as data holders and lets each operation control traversal without putting business operations into the tree.

## Trade-off proof
- **New visitor:** add a class implementing `Visitor<R>`; no existing element class changes.
- **New element:** add a new element class and add a `visitNewElement(...)` method to `Visitor<R>`, then update every visitor. This is the main cost of Visitor and is a reason to reconsider the pattern when element types change frequently.

## UML
See `docs/uml.puml`.

## Git history
The assignment asks for a meaningful history over two weeks. This package intentionally does **not** fabricate historical commit dates. Create your own commits while developing, for example:
1. Observer interfaces + event model
2. Visitor tree + first visitors
3. Integration + concurrency
4. Tests + README + UML

Then make the required two separate trade-off commits: one adding a visitor without element changes, and one adding an element type.
