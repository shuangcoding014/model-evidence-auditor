# Model and explanation card

## Intended purpose

This small, transparent Java model tests explanation-metric implementations. It must not be used for lending, eligibility, employment, insurance, or any decision about a person.

## Data

The repository does not contain or generate a training dataset. Unit tests use short, fictional feature maps, weights, and baselines so that every expected contribution can be checked by hand. `examples/evidence.json` is also fictional; it represents evidence supplied to the auditor rather than model-generated results.

## Model and explanation

`LinearRiskModel` is a transparent logistic risk model. Its local explanation decomposes log-odds into exact feature contributions relative to a declared baseline. This design verifies metric implementation, but it is not a causal explanation and does not establish usefulness for an intended audience.

## Evaluation

- exact log-odds reconstruction error as a limited fidelity diagnostic;
- top-k Jaccard overlap for comparing two contribution rankings;
- documentation-presence checks linked to a versioned review profile.

The CLI consumes precomputed evidence and does not calculate these metrics. The sample JSON contains additional illustrative fields that are not active audit rules. All thresholds are declared research choices. Passing one is evidence for review, not proof of compliance, fairness, usefulness, or safety.
