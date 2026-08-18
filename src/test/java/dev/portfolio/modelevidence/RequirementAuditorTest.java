package dev.portfolio.modelevidence;

import dev.portfolio.modelevidence.audit.RequirementAuditor;
import dev.portfolio.modelevidence.domain.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class RequirementAuditorTest {
    @Test void reportsEvidenceWithoutOverclaiming() {
        var rule = new Requirement("FIDELITY", "Transparent Model Review", "Fidelity", "Interpretability evidence",
                "https://eur-lex.europa.eu/eli/reg/2024/1689/oj", "fidelityError", Direction.MAXIMUM, 0.1, null);
        var evidence = new SystemEvidence("demo", "research", "synthetic", Map.of("fidelityError", 0.02), Map.of());
        var finding = new RequirementAuditor().audit(List.of(rule), evidence).getFirst();
        assertEquals(EvidenceStatus.EVIDENCE_PRESENT, finding.status());
        assertFalse(finding.interpretation().toLowerCase().contains("compliant"));
    }

    @Test void rejectsRulesWithoutPrimarySources() {
        assertThrows(IllegalArgumentException.class, () -> new Requirement(
                "R", "profile", "reference", "claim", "not-a-url", null, null, null, "modelCard"));
    }
}
