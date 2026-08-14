package dev.portfolio.trustreg;

import dev.portfolio.trustreg.audit.RequirementAuditor;
import dev.portfolio.trustreg.domain.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class RequirementAuditorTest {
    @Test void callsResultEvidenceNotCompliance() {
        var rule = new Requirement("EU-AIA-13", "EU AI Act", "Article 13", "Interpretability evidence",
                "https://eur-lex.europa.eu/eli/reg/2024/1689/oj", "fidelityError", Direction.MAXIMUM, 0.1, null);
        var evidence = new SystemEvidence("demo", "research", "synthetic", Map.of("fidelityError", 0.02), Map.of());
        var finding = new RequirementAuditor().audit(List.of(rule), evidence).getFirst();
        assertEquals(EvidenceStatus.EVIDENCE_PRESENT, finding.status());
        assertFalse(finding.interpretation().toLowerCase().contains("compliant"));
    }

    @Test void rejectsRulesWithoutPrimarySources() {
        assertThrows(IllegalArgumentException.class, () -> new Requirement(
                "R", "framework", "article", "claim", "not-a-url", null, null, null, "modelCard"));
    }
}
