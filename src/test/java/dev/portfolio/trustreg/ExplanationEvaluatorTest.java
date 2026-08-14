package dev.portfolio.trustreg;

import dev.portfolio.trustreg.xai.ExplanationEvaluator;
import dev.portfolio.trustreg.xai.LinearRiskModel;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExplanationEvaluatorTest {
    @Test void exactLinearContributionsHaveZeroLogOddsFidelityError() {
        var model = new LinearRiskModel(-0.2, Map.of("signal", 1.5, "context", -0.4));
        var row = Map.of("signal", 0.8, "context", 0.3);
        var baseline = Map.of("signal", 0.0, "context", 0.0);
        assertEquals(0.0, ExplanationEvaluator.fidelityError(model, row, baseline, model.explain(row, baseline)), 1e-12);
    }

    @Test void topKStabilityUsesFeatureOverlap() {
        assertEquals(1.0, ExplanationEvaluator.topKJaccard(
                Map.of("a", 3.0, "b", 2.0, "c", 1.0), Map.of("a", 2.9, "b", 2.1, "c", 0.8), 2));
    }
}
