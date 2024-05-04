package app.handicraft.dto.updateApplicant;

import java.util.UUID;

public record UpdateApplicantResponse (
        UUID id,
        String userName
) {
}
