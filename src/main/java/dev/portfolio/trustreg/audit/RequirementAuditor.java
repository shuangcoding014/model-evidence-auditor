package dev.portfolio.trustreg.audit;

import dev.portfolio.trustreg.domain.*;
import java.util.List;

public final class RequirementAuditor {
    public List<Finding> audit(List<Requirement> requirements, SystemEvidence evidence) {
        return requirements.stream().map(rule -> evaluate(rule, evidence)).toList();
    }

    private Finding evaluate(Requirement rule, SystemEvidence evidence) {
        boolean present;
        String observed;
        if (rule.metric() != null) {
            Double value = evidence.metrics().get(rule.metric());
            present = value != null && (rule.direction() == Direction.MAXIMUM
                    ? value <= rule.researchThreshold() : value >= rule.researchThreshold());
            observed = value == null ? "metric missing: " + rule.metric()
                    : "%s=%.4f; researcher threshold=%s %.4f".formatted(
                            rule.metric(), value, rule.direction(), rule.researchThreshold());
        } else {
            present = evidence.documentation().getOrDefault(rule.documentationField(), false);
            observed = rule.documentationField() + " documented=" + present;
        }
        String interpretation = present
                ? "Requested evidence is present for researcher review."
                : "Evidence gap: collect or improve this evidence before making a trustworthiness claim.";
        return new Finding(rule.id(), rule.framework(), rule.article(),
                present ? EvidenceStatus.EVIDENCE_PRESENT : EvidenceStatus.EVIDENCE_GAP,
                observed, interpretation, rule.sourceUrl());
    }
}
