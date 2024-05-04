package app.handicraft.dto.createApplicant;

import java.util.UUID;

public record CreateApplicantResponse(
        String userName,
        UUID id
) {
}
