# Architecture and design decisions

## Component map

```text
policy/requirements.json       examples/evidence.json
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

### Typed evidence instead of free-form compliance claims

`Requirement`, `SystemEvidence`, and `Finding` are Java records. A requirement must contain an HTTPS primary-source link and exactly one supported evidence mechanism: a metric with a direction and threshold, or a documentation field. Invalid mappings fail at ingestion instead of silently producing a report.

### Evidence states instead of pass/fail compliance

The engine emits `EVIDENCE_PRESENT`, `EVIDENCE_GAP`, or `NOT_APPLICABLE`. A technical metric cannot by itself establish that a legal obligation has been satisfied. This vocabulary keeps the software useful for interdisciplinary review without presenting it as automated legal advice.

### Versioned and reviewable policy mappings

Requirements live in JSON so changes are visible in Git. Every entry records its jurisdiction/framework, article, engineering interpretation, source, and evidence test. In a research deployment, each mapping would additionally have two independent coders, an adjudication record, and effective dates.

### No redistribution of ISO text

ISO/IEC 27701 is relevant to the project's privacy-management analysis, but the standard is copyrighted. The repository links to ISO's official catalogue and models whether an authorized control mapping has been reviewed; it does not reproduce proprietary control language.

### Small transparent ML example

The Java `LinearRiskModel` exists to test explanation mechanics. Exact log-odds contributions make the expected fidelity result independently checkable. It is a synthetic teaching model, not a production AI system or a claim that linear models solve explainability.

## Extension points

- add Jackson polymorphic evidence tests for confidence intervals, robustness, and human evaluation;
- ingest model cards using a documented JSON Schema;
- add framework applicability logic based on system role, use context, geography, and risk classification;
- implement dual-coder policy annotations and Cohen's kappa;
- connect external Python/R evaluation jobs through versioned JSON artifacts without moving the Java audit core;
- add provenance hashes and signed reports for industrial audit trails.
