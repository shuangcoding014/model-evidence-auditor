package dev.portfolio.modelevidence.xai;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class ExplanationEvaluator {
    private ExplanationEvaluator() {}

    public static double fidelityError(LinearRiskModel model, Map<String, Double> features,
                                       Map<String, Double> baseline, Map<String, Double> explanation) {
        double reconstructed = model.baselineLogit(baseline)
                + explanation.values().stream().mapToDouble(Double::doubleValue).sum();
        return Math.abs(model.logit(features) - reconstructed);
    }

    public static double topKJaccard(Map<String, Double> first, Map<String, Double> second, int k) {
        Set<String> a = topK(first, k);
        Set<String> b = topK(second, k);
        Set<String> union = new HashSet<>(a); union.addAll(b);
        Set<String> intersection = new HashSet<>(a); intersection.retainAll(b);
        return union.isEmpty() ? 1.0 : (double) intersection.size() / union.size();
    }

    private static Set<String> topK(Map<String, Double> values, int k) {
        Set<String> result = new HashSet<>();
        values.entrySet().stream()
                .sorted((a, b) -> Double.compare(Math.abs(b.getValue()), Math.abs(a.getValue())))
                .limit(k).forEach(entry -> result.add(entry.getKey()));
        return result;
    }
}
