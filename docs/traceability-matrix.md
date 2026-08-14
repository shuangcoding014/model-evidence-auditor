# Requirement traceability matrix

This matrix explains what the prototype demonstrates and, equally importantly, what it does not claim.

| Framework | Research interpretation represented in code | Evidence field | Important limitation |
|---|---|---|---|
| EU AI Act, Article 13 | Evidence should help a deployer interpret output and understand limitations | `fidelityError`, `knownLimitations` | Fidelity is only one dimension of useful interpretation |
| EU AI Act, Article 14 | Human-oversight arrangements should be documented | `humanOversight` | A Boolean proves artifact presence, not oversight effectiveness |
| GDPR, Article 5(1)(c) | The project should record a data-minimisation rationale | `dataMinimisationRationale` | Necessity and proportionality require contextual legal analysis |
| CCPA | Consumer-facing notice evidence should be inventoried | `consumerNotice` | Applicability and notice content are outside the automatic check |
| ISO/IEC 27701 | Record whether an authorized PIMS control mapping exists | `iso27701ControlMapping` | The repository does not redistribute or certify against ISO controls |

## Coding protocol for a real study

1. Freeze the official source version and effective date.
2. Have two researchers independently extract candidate requirements.
3. Record inclusion/exclusion criteria and resolve disagreements.
4. Ask a domain expert to review the engineering interpretation.
5. Keep raw legal text separate from the operationalized test.
6. Report inter-rater agreement and unresolved ambiguity.
7. Re-run mappings when the law, guidance, or system context changes.

