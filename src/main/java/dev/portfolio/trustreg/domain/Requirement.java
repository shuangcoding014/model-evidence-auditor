package dev.portfolio.trustreg.domain;

public record Requirement(
        String id,
        String framework,
        String article,
        String requirement,
        String sourceUrl,
        String metric,
        Direction direction,
        Double researchThreshold,
        String documentationField) {

    public Requirement {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Requirement id is mandatory");
        if (sourceUrl == null || !sourceUrl.startsWith("https://")) {
            throw new IllegalArgumentException("A primary-source HTTPS URL is mandatory");
        }
        boolean metricEvidence = metric != null && researchThreshold != null && direction != null;
        boolean documentEvidence = documentationField != null;
        if (metricEvidence == documentEvidence) {
            throw new IllegalArgumentException("Choose exactly one evidence type for " + id);
        }
    }
}
