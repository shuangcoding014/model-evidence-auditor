# TrustReg Auditor

A Java 21 research prototype that evaluates ML-explainability evidence and maps technical and documentation gaps across the EU AI Act, GDPR, CCPA, and ISO/IEC 27701.

## Why Java is central

The complete application—domain model, rule validation, XAI metric evaluation, JSON ingestion, audit engine, CLI, and report generation—is implemented in Java. Records and enums make the evidence model explicit; immutable collections reduce accidental mutation; JUnit tests cover metric correctness and prevent compliance overclaiming.

## Run

```bash
mvn test
mvn package
java -jar target/trustreg-auditor.jar \
  policy/requirements.json examples/evidence.json artifacts/demo
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

The project is a structured engineering interpretation, not legal advice or a conformity assessment. See [MODEL_CARD.md](MODEL_CARD.md) and [research-note.md](docs/research-note.md).
