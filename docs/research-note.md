# Research note: explanation effectiveness as testable evidence

## Question

What evidence should accompany a claim that an explanation helps a deployer interpret an ML output?

## Approach

The Java audit model separates four concepts often collapsed into “explainability”:

1. **fidelity** — approximate reconstruction error between predictions and summed local contributions;
2. **stability** — overlap and rank agreement under small perturbations;
3. **slice reliability** — disparity in fidelity error across synthetic audit groups;
4. **documentation** — intended users, limitations, and human-oversight instructions.

The JSON requirements registry makes the mapping, primary source, metric, direction, documentation field, and researcher-chosen threshold reviewable in Git history. Java records validate every requirement at ingestion so malformed or unsourced mappings fail early.

## Expected interpretation

A low reconstruction error can coexist with unstable feature rankings. Both can coexist with explanations that are meaningless to a particular user. The report therefore preserves separate findings rather than producing a single “XAI score.”

## Limitations and extensions

The demo evidence is synthetic, the linear explanation is not causal, and documentation booleans establish only artifact availability. A research extension would ingest model-independent explanations, add human-subject usefulness evaluation, bootstrap confidence intervals, test multilingual notices, and perform double-coded legal analysis with inter-rater agreement.

## Primary references

- European Union, [Regulation (EU) 2024/1689](https://eur-lex.europa.eu/eli/reg/2024/1689/oj), especially Articles 13–14.
- NIST, [Four Principles of Explainable Artificial Intelligence](https://www.nist.gov/publications/four-principles-explainable-artificial-intelligence).
- NIST, [AI Risk Management Framework](https://www.nist.gov/itl/ai-risk-management-framework).
