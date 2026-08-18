# Requirement traceability matrix

This matrix shows what the default review profile tests and what each result leaves unresolved.

| Review area | Evidence field | What the check establishes | Important limitation |
|---|---|---|---|
| Explanation fidelity | `fidelityError` | A supplied value is below the profile threshold | Fidelity is only one dimension of a useful explanation |
| Ranking stability | `top3Stability` | A supplied value is above the profile threshold | Aggregate overlap can hide instance-level failures |
| Known limitations | `knownLimitations` | An artifact is recorded as available | Presence does not establish completeness |
| Human review | `humanReviewProcedure` | A procedure is recorded as available | Presence does not establish effectiveness |
| Data provenance | `dataProvenance` | Provenance material is recorded as available | The Boolean does not validate the underlying data |
| Evaluation protocol | `evaluationProtocol` | An evaluation protocol is recorded as available | The Boolean does not validate study design |

## Profile-authoring protocol

1. Define the intended reviewer and decision context.
2. State inclusion and exclusion criteria for each evidence item.
3. Cite a stable supporting source.
4. Label numerical thresholds as research or organizational choices.
5. Review the profile independently before use.
6. Preserve profile and evidence versions with every report.
