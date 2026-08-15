# TrustReg Auditor

A Java 21 research prototype that evaluates ML-explainability evidence and maps technical and documentation gaps across the EU AI Act, GDPR, CCPA, and ISO/IEC 27701.

## Why Java is central

The complete application—domain model, rule validation, XAI metric evaluation, JSON ingestion, audit engine, CLI, and report generation—is implemented in Java. Records and enums make the evidence model explicit; immutable collections reduce accidental mutation; JUnit tests cover metric correctness and prevent compliance overclaiming.

## Prerequisites

- Java Development Kit (JDK) 21
- Apache Maven 3.9 or later

Confirm that both tools are available:

```bash
java --version
mvn --version
```

## Quick start

```bash
mvn --batch-mode verify
java -jar target/trustreg-auditor.jar \
  policy/requirements.json examples/evidence.json artifacts/demo
```

The command should finish with:

```text
Audited 6 requirements; 2 evidence gap(s).
```

Outputs:

- `findings.json`: machine-readable `EVIDENCE_PRESENT`/`EVIDENCE_GAP` results;
- `report.md`: source-linked technical/regulatory gap report.

## Research design

```text
ML system evidence -> Java evidence model -> requirement audit engine
                                                |-> findings.json
versioned EU/GDPR/CCPA/ISO mapping --------------|-> report.md
```

`LinearRiskModel` and `ExplanationEvaluator` also demonstrate explanation fidelity and top-k stability for a transparent synthetic model. Research thresholds are deliberately labelled as engineering choices, not statutory safe harbours. ISO control text is not reproduced; the demo records only whether an authorized mapping exists.

The CLI audits supplied evidence; it does not train a model or calculate the example metrics. The metric helper classes are exercised independently by the JUnit test suite. The sample evidence is fictional and exists only to make the audit workflow reproducible.

## Repository guide

- `src/main/java`: Java domain model, audit engine, metric helpers, CLI, and report writer
- `src/test/java`: unit tests for rule evaluation and explanation metrics
- `policy/requirements.json`: source-linked, versioned research interpretations
- `examples/evidence.json`: fictional input evidence
- `docs`: architecture, traceability, and research-method notes

## Troubleshooting

- `invalid target release: 21`: install JDK 21 and ensure `JAVA_HOME` points to it.
- `mvn: command not found`: install Apache Maven 3.9 or later.
- `Unable to access jarfile`: run `mvn --batch-mode verify` from the repository root before starting the CLI.

The project is a structured engineering interpretation, not legal advice or a conformity assessment. See [MODEL_CARD.md](MODEL_CARD.md) and [research-note.md](docs/research-note.md).
