# Architecture and design decisions

## Component map

```text
profiles/transparent-model-review.json       examples/evidence.json
          |                              |
          +-------- JsonRepository ------+
                         |
                validated Java records
                         |
               RequirementAuditor
                    /          \
          findings.json       report.md

LinearRiskModel -> ExplanationEvaluator -> metric evidence
```

## Design decisions

### Typed evidence

`Requirement`, `SystemEvidence`, and `Finding` are Java records. Each rule contains an HTTPS source and exactly one evidence mechanism: a metric threshold or a documentation field. Invalid profiles fail when loaded.

### Evidence states instead of a composite score

The engine emits `EVIDENCE_PRESENT` or `EVIDENCE_GAP`. Separate findings preserve context that would be lost in a single score and make missing artifacts visible.

### Versioned profiles

Requirements live in JSON so profile changes remain reviewable in Git. Each entry records a profile, reference, interpretation, source, and evidence test. Teams can create profiles for different models or review contexts without changing the Java engine.

### Transparent metric example

The Java `LinearRiskModel` exists to test explanation mechanics. Exact log-odds contributions make the expected fidelity result independently checkable. It is a fictional teaching model, not a production AI system.

## Extension points

- validate evidence packages with JSON Schema;
- add confidence intervals, robustness checks, and human evaluation;
- support profile applicability metadata;
- add provenance hashes and signed reports;
- connect external Python or R evaluation jobs through versioned JSON artifacts.
