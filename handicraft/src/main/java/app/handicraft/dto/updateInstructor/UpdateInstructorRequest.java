package app.handicraft.dto.updateInstructor;

import java.util.UUID;

public record UpdateInstructorRequest(
        UUID id,
        String userName,
        String name,
        String surname,
        String eMail,
        String phoneNumber,
        String address,
        Float  fee
) {
}
