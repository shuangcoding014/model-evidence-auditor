package dev.portfolio.modelevidence.io;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dev.portfolio.modelevidence.domain.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public final class JsonRepository {
    private final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public List<Requirement> readRequirements(Path path) throws IOException {
        return mapper.readValue(path.toFile(), new TypeReference<>() {});
    }

    public SystemEvidence readEvidence(Path path) throws IOException {
        return mapper.readValue(path.toFile(), SystemEvidence.class);
    }

    public void writeFindings(Path path, List<Finding> findings) throws IOException {
        mapper.writeValue(path.toFile(), findings);
    }
}
