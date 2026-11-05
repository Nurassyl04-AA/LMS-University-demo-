# University LMS (Topic 5) - Simple & Clean

## Overview
Simple Java 17 implementation of a University LMS system demonstrating **Observer** and **Visitor** patterns.

### Topic 5 Structure:
- **Observer:** `GradePosted`, `DeadlineApproaching` events.
- **Visitor Composite Tree:** `Faculty` → `Program` → `Course` → `Lecture`, `Lab`, `Exam`.
- **Visitors:** `CreditsVisitor`, `WorkloadVisitor`, `JsonExportVisitor`, `StatisticsVisitor`.
- **Integration:** Event triggers a Visitor scan on the subtree.
- **Concurrency:** Thread-safe `ConcurrentSubject` with JUnit 5 stress testing.
