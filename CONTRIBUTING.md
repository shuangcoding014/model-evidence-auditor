# Contributing

## Local checks

```bash
mvn --batch-mode verify
java -jar target/model-evidence-auditor.jar \
  profiles/transparent-model-review.json examples/evidence.json artifacts/demo
```

## Adding a requirement

1. Define the intended reviewer and use context.
2. Link to a stable supporting source.
3. Paraphrase the evidence expectation narrowly.
4. Choose exactly one documentation field or metric.
5. Label numerical thresholds as research or organizational choices.
6. Add tests for new evaluation behavior.
7. Obtain an independent review for substantive profile changes.

## Pull-request checklist

- [ ] Tests pass on Java 21.
- [ ] The example report is reproducible.
- [ ] No personal, confidential, or production data are committed.
- [ ] Sources are properly attributed.
- [ ] Findings do not overstate what the supplied evidence establishes.
- [ ] Limitations and assumptions are current.
