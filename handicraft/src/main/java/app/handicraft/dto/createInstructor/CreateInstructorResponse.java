package app.handicraft.dto.createInstructor;

import java.util.UUID;

public record CreateInstructorResponse(
        String userName,
        UUID id
) {
}
