package dev.portfolio.trustreg.report;

import dev.portfolio.trustreg.domain.Finding;
import dev.portfolio.trustreg.domain.SystemEvidence;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class MarkdownReporter {
    public void write(Path path, SystemEvidence evidence, List<Finding> findings) throws IOException {
        StringBuilder text = new StringBuilder("# TrustReg evidence report\n\n")
                .append("System: **").append(evidence.systemName()).append("**\n\n")
                .append("Purpose: ").append(evidence.intendedPurpose()).append("\n\n")
                .append("Risk context: ").append(evidence.riskContext()).append("\n\n## Findings\n\n");
        for (Finding finding : findings) {
            text.append("### ").append(finding.requirementId()).append(": ").append(finding.status()).append("\n\n")
                    .append(finding.framework()).append(" ").append(finding.article()).append("\n\n")
                    .append("Evidence: ").append(finding.observedEvidence()).append("\n\n")
                    .append(finding.interpretation()).append("\n\n")
                    .append("Primary source: ").append(finding.sourceUrl()).append("\n\n");
        }
        text.append("## Interpretation boundary\n\n")
                .append("This report maps technical evidence to review criteria. It is not legal advice, a conformity assessment, or a compliance determination.\n");
        Files.writeString(path, text);
    }
}
