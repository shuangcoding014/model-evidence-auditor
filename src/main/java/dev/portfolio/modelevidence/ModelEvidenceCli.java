package dev.portfolio.modelevidence;

import dev.portfolio.modelevidence.audit.RequirementAuditor;
import dev.portfolio.modelevidence.io.JsonRepository;
import dev.portfolio.modelevidence.report.MarkdownReporter;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ModelEvidenceCli {
    private ModelEvidenceCli() {}

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Usage: java -jar model-evidence-auditor.jar REQUIREMENTS.json EVIDENCE.json OUTPUT_DIR");
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
