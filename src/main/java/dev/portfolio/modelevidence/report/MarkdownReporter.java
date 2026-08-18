package dev.portfolio.modelevidence.report;

import dev.portfolio.modelevidence.domain.Finding;
import dev.portfolio.modelevidence.domain.SystemEvidence;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class MarkdownReporter {
    public void write(Path path, SystemEvidence evidence, List<Finding> findings) throws IOException {
        StringBuilder text = new StringBuilder("# Model evidence report\n\n")
                .append("System: **").append(evidence.systemName()).append("**\n\n")
                .append("Purpose: ").append(evidence.intendedPurpose()).append("\n\n")
                .append("Risk context: ").append(evidence.riskContext()).append("\n\n## Findings\n\n");
        for (Finding finding : findings) {
            text.append("### ").append(finding.requirementId()).append(": ").append(finding.status()).append("\n\n")
                    .append(finding.profile()).append(" ").append(finding.reference()).append("\n\n")
                    .append("Evidence: ").append(finding.observedEvidence()).append("\n\n")
                    .append(finding.interpretation()).append("\n\n")
                    .append("Primary source: ").append(finding.sourceUrl()).append("\n\n");
        }
        text.append("## Interpretation boundary\n\n")
                .append("This report compares supplied evidence with a review profile. A passing result does not establish fairness, usefulness, safety, or compliance.\n");
        Files.writeString(path, text);
    }
}
