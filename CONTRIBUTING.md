# Contributing

## Local checks

```bash
mvn verify
mvn package
java -jar target/trustreg-auditor.jar policy/requirements.json examples/evidence.json artifacts/demo
```

## Adding a requirement

1. Link to a primary official source.
2. Paraphrase narrowly; do not copy copyrighted standards text.
3. Identify framework, article/control family, applicability assumptions, and effective date.
4. Choose one auditable evidence field or metric.
5. Label numeric thresholds as researcher-defined unless the authoritative source explicitly sets them.
6. Add tests for new evaluation behavior.
7. Obtain a second coder's review for substantive policy mappings.

## Pull-request checklist

- [ ] Tests pass on Java 21.
- [ ] Example report is reproducible.
- [ ] No personal, partner-confidential, or production data are committed.
- [ ] Legal and standards sources are properly attributed.
- [ ] Findings do not use unsupported “compliant/non-compliant” language.
- [ ] Limitations and assumptions are updated.

