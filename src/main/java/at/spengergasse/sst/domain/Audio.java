package at.spengergasse.sst.domain;

import java.time.Duration;
import java.time.Instant;

public record Audio(
    String Id,
    Instant createdAt,
    String fileName,
    String mimeType,
    long size,
    Duration duration
) {
}
