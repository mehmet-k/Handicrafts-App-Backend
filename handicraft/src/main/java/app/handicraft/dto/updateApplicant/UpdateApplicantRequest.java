package app.handicraft.dto.updateApplicant;

import java.util.UUID;

public record UpdateApplicantRequest(
        String userName,
        String name,
        String surname,
        String eMail,
        String phoneNumber,
        String address
) {
}
