# Research note: explanation effectiveness as testable evidence

## Question

What evidence should accompany a claim that an explanation helps a deployer interpret an ML output?

## Approach

The prototype keeps several concepts that are often collapsed into “explainability” separate:

1. **fidelity**: reconstruction error between a model's log-odds and summed local contributions;
2. **ranking overlap**: top-k Jaccard overlap between two contribution maps;
3. **documentation**: recorded limitations, intended use, and human-oversight material.

The JSON requirements registry makes the mapping, primary source, metric, direction, documentation field, and researcher-chosen threshold reviewable in Git history. Java records validate every requirement at ingestion so malformed or unsourced mappings fail early.

## Expected interpretation

A low reconstruction error can coexist with unstable feature rankings. Both can coexist with explanations that are meaningless to a particular user. The report therefore preserves separate findings instead of producing a single "XAI score."

## Limitations and extensions

The CLI audits supplied JSON evidence; it does not train a model or compute metrics. The demo evidence is fictional, the linear explanation is not causal, and documentation booleans establish only artifact availability. A research extension could ingest model-independent explanations, calculate confidence intervals and slice diagnostics, add human-subject usefulness evaluation, test multilingual notices, and perform double-coded legal analysis with inter-rater agreement.

## Primary references

- European Union, [Regulation (EU) 2024/1689](https://eur-lex.europa.eu/eli/reg/2024/1689/oj), especially Articles 13–14.
- NIST, [Four Principles of Explainable Artificial Intelligence](https://www.nist.gov/publications/four-principles-explainable-artificial-intelligence).
- NIST, [AI Risk Management Framework](https://www.nist.gov/itl/ai-risk-management-framework).
