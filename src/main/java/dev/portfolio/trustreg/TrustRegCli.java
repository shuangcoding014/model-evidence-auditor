package dev.portfolio.trustreg;

import dev.portfolio.trustreg.audit.RequirementAuditor;
import dev.portfolio.trustreg.io.JsonRepository;
import dev.portfolio.trustreg.report.MarkdownReporter;
import java.nio.file.Files;
import java.nio.file.Path;

public final class TrustRegCli {
    private TrustRegCli() {}

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Usage: java -jar trustreg-auditor.jar REQUIREMENTS.json EVIDENCE.json OUTPUT_DIR");
            System.exit(2);
        }
        Path output = Path.of(args[2]);
        Files.createDirectories(output);
        JsonRepository repository = new JsonRepository();
        var requirements = repository.readRequirements(Path.of(args[0]));
        var evidence = repository.readEvidence(Path.of(args[1]));
        var findings = new RequirementAuditor().audit(requirements, evidence);
        repository.writeFindings(output.resolve("findings.json"), findings);
        new MarkdownReporter().write(output.resolve("report.md"), evidence, findings);
        long gaps = findings.stream().filter(item -> item.status().name().equals("EVIDENCE_GAP")).count();
        System.out.printf("Audited %d requirements; %d evidence gap(s).%n", findings.size(), gaps);
    }
}
