package app.handicraft.dto.updateInstructor;

import java.util.UUID;

public record UpdateInstructorResponse(
        UUID id,
        String userName
) {
}
