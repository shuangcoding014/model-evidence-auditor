package dev.portfolio.trustreg.domain;

public record Finding(
        String requirementId,
        String framework,
        String article,
        EvidenceStatus status,
        String observedEvidence,
        String interpretation,
        String sourceUrl) {}
