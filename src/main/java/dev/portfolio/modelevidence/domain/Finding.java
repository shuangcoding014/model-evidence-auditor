package dev.portfolio.modelevidence.domain;

public record Finding(
        String requirementId,
        String profile,
        String reference,
        EvidenceStatus status,
        String observedEvidence,
        String interpretation,
        String sourceUrl) {}
