# Research note: explanation claims as testable evidence

## Question

What evidence should accompany a claim that an explanation helps a reviewer understand a model output?

## Approach

The prototype keeps several concepts separate:

1. **fidelity**: reconstruction error between a model's log-odds and summed local contributions;
2. **ranking overlap**: top-k Jaccard overlap between two contribution maps;
3. **documentation**: recorded limitations, evaluation scope, data provenance, and human-review procedures.

The JSON profile makes every metric, direction, threshold, documentation field, and supporting source reviewable in Git history. Java records validate each requirement when it is loaded so malformed or unsourced rules fail early.

## Interpretation

A low reconstruction error can coexist with unstable feature rankings. Both can coexist with explanations that are unhelpful to a particular user. The report therefore preserves separate findings instead of producing a single explanation score.

The CLI audits supplied evidence; it does not train a model or compute metrics. The evidence package is fictional, the linear explanation is not causal, and documentation booleans establish only artifact availability. Extensions could add confidence intervals, slice diagnostics, model-independent explanations, and human-subject usefulness evaluation.

## References

- NIST, [Four Principles of Explainable Artificial Intelligence](https://www.nist.gov/publications/four-principles-explainable-artificial-intelligence).
- NIST, [AI Risk Management Framework](https://www.nist.gov/itl/ai-risk-management-framework).
