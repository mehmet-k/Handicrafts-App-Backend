package app.handicraft.dto.createApplicant;

public record CreateApplicantRequest(
        String userName,
        String name,
        String surname,
        String eMail,
        String phoneNumber,
        String address
) {
}
