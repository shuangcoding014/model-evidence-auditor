package dev.portfolio.modelevidence.domain;

import java.util.Map;

public record SystemEvidence(
        String systemName,
        String intendedPurpose,
        String riskContext,
        Map<String, Double> metrics,
        Map<String, Boolean> documentation) {

    public SystemEvidence {
        metrics = metrics == null ? Map.of() : Map.copyOf(metrics);
        documentation = documentation == null ? Map.of() : Map.copyOf(documentation);
    }
}
