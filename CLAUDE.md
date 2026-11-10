# checkout-nearby-shops — instructions for Claude

This is a **live-coding interview re-run**: the owner leads and gives instructions as they would to Claude Code in an interview. Never design for the owner: when a decision is needed (API shape, ranking rule, error handling), ask a question and let the owner decide. The owner must understand every line. After each step, ask 1–2 interview-style questions.

## How to work here

1. **Explain before coding, then wait for approval.** Before each change, say in plain words what you're about to add, to which service, and why. Then **stop and wait for the owner's OK** before editing any file. Don't do the next step until the current one is approved. This also applies to running commands that change things (starting or stopping containers, deleting files, installing anything).
2. **Go in small steps, one concept at a time.** Don't build a whole feature in one go. After each step, show:
   - which module it belongs to (`buyer`, `ad`, `location`, `courier` or `checkout`)
   - which files were added or changed
   - the key lines, and what each one does
   - how to try that step yourself (a curl command, a test, or a log line to look for)
3. **Name the concept** behind each step (for example "JPA lazy loading", "transactional outbox", "KTable aggregation") so it can be looked up later.
4. **Keep the build log up to date.** Add each finished step to `docs/BUILD_LOG.md` using the same format as the entries already there.
5. **Use plain language** and avoid unexplained jargon. Short analogies are welcome.

## Code review and coding rules

Follow Effective Java (Joshua Bloch, 3rd edition) principles. When you
apply or flag one, name the principle so I can look it up.

### Priorities for every review, in this order
1. Correctness against the requirement. Trace one real example.
2. Money and data safety: no double charges, no lost events, no partial updates.
3. Concurrency: races, check-then-act, shared mutable state in beans.
4. Failure handling: crashes, retries, timeouts, duplicate Kafka messages.
5. Security: no card or personal data in logs, input validation.
6. Tests: missing cases, especially failure and duplicate cases.
7. Readability and design.

### Java rules (Effective Java)
- Prefer immutable objects; use records for DTOs and events.
- Use constructor injection; make fields final.
- Use enums instead of string or int constants (e.g. order status).
- Override equals and hashCode together; keep them consistent.
- Return Optional instead of null; never call Optional.get() without a check.
- Catch specific exceptions; never swallow them.
- Use exceptions only for exceptional conditions.
- Use BigDecimal or long minor units for money, never double.
- Minimize visibility and mutability of classes and members.
- Validate parameters at public boundaries.

### Project rules
- Java 21, Spring Boot, PostgreSQL, Kafka.
- @Transactional only on public methods called from another bean.
- No external calls (HTTP, Kafka send) inside a database transaction;
  use the outbox pattern.
- Kafka consumers must be idempotent; key events by aggregate ID (e.g. orderId).

### How to work with me
- Propose a plan before changing code, and wait for my approval.
- Make small changes and run the tests after each one.
- For each review finding, give: issue, what fails in production, fix, trade-off.
