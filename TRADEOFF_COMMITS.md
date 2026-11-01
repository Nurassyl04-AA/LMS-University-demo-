# Required trade-off commits

Do not submit invented history. After importing this project, make the two required changes as real commits in your own repository.

## Commit A — new visitor, no element changes
Add a visitor such as `CourseNameVisitor` and its tests. The element directory must remain unchanged. Explain that Visitor makes adding operations cheap.

## Commit B — new element type
Add an element such as `Seminar`. This requires adding `visitSeminar` to `Visitor<R>` and updating every visitor. Explain that this is the cost of Visitor when the element hierarchy changes.
