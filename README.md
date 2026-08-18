# ModelEvidence Auditor

A Java 21 toolkit for validating structured evidence about model behavior, explanation quality, documentation, and operational review controls.

The project treats assurance as an evidence-management problem. A versioned profile declares the metric thresholds and documentation artifacts expected for a review; the CLI evaluates a supplied evidence package and produces machine-readable findings and a concise report.

## What it demonstrates

- a typed Java domain model built with records and enums;
- validated JSON ingestion with Jackson;
- reusable metric and documentation checks;
- a small rule engine with explicit evidence states;
- explanation fidelity and top-k overlap helpers;
- JUnit tests, Maven packaging, and a command-line interface.

The default profile is a general transparent-model review. It is suitable for internal quality review, reproducibility exercises, or as a foundation for organization-specific assurance profiles. It is not tied to one industry or legal regime.

## Prerequisites

- Java Development Kit (JDK) 21
- Apache Maven 3.9 or later

```bash
java --version
mvn --version
```

## Quick start

```bash
mvn --batch-mode verify
java -jar target/model-evidence-auditor.jar \
  profiles/transparent-model-review.json examples/evidence.json artifacts/demo
```

The command should finish with:

```text
Audited 6 requirements; 1 evidence gap(s).
```

Outputs:

- `findings.json`: machine-readable `EVIDENCE_PRESENT` and `EVIDENCE_GAP` results;
- `report.md`: a source-linked evidence review.

## Architecture

```text
evidence package -> validated Java records -> requirement audit engine
                                                   |-> findings.json
versioned assurance profile -----------------------|-> report.md
```

`LinearRiskModel` and `ExplanationEvaluator` demonstrate explanation fidelity and top-k overlap for a transparent fictional model. The CLI consumes precomputed evidence; it does not train a model or calculate the example metrics. The helper classes are tested independently by JUnit.

## Repository guide

- `src/main/java`: domain model, audit engine, metric helpers, CLI, and report writer
- `src/test/java`: unit tests for rule evaluation and explanation metrics
- `profiles/transparent-model-review.json`: the versioned transparent-model review profile
- `examples/evidence.json`: a fictional evidence package
- `docs`: architecture, traceability, and method notes

## Interpretation boundary

Passing a rule means only that the declared evidence was present or met a profile threshold. It does not establish fairness, usefulness, safety, or compliance. See [MODEL_CARD.md](MODEL_CARD.md) and [research-note.md](docs/research-note.md).

## Troubleshooting

- `invalid target release: 21`: install JDK 21 and ensure `JAVA_HOME` points to it.
- `mvn: command not found`: install Apache Maven 3.9 or later.
- `Unable to access jarfile`: run `mvn --batch-mode verify` from the repository root first.
