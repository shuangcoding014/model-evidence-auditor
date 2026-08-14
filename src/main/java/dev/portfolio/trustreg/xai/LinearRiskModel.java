package dev.portfolio.trustreg.xai;

import java.util.LinkedHashMap;
import java.util.Map;

/** A deterministic demo model; it must never be used for decisions about people. */
public final class LinearRiskModel {
    private final double intercept;
    private final Map<String, Double> weights;

    public LinearRiskModel(double intercept, Map<String, Double> weights) {
        this.intercept = intercept;
        this.weights = Map.copyOf(weights);
    }

    public double probability(Map<String, Double> features) {
        double logit = intercept;
        for (var entry : weights.entrySet()) logit += entry.getValue() * features.getOrDefault(entry.getKey(), 0.0);
        return 1.0 / (1.0 + Math.exp(-logit));
    }

    /** Exact log-odds contributions for this transparent linear model. */
    public Map<String, Double> explain(Map<String, Double> features, Map<String, Double> baseline) {
        Map<String, Double> result = new LinkedHashMap<>();
        for (var entry : weights.entrySet()) {
            result.put(entry.getKey(), entry.getValue()
                    * (features.getOrDefault(entry.getKey(), 0.0) - baseline.getOrDefault(entry.getKey(), 0.0)));
        }
        return result;
    }

    public double baselineLogit(Map<String, Double> baseline) {
        return intercept + explain(baseline, Map.of()).values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public double logit(Map<String, Double> features) {
        double probability = probability(features);
        return Math.log(probability / (1.0 - probability));
    }
}
