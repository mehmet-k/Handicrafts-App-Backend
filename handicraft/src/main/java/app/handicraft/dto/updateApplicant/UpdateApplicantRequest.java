package app.handicraft.dto.updateApplicant;

public record UpdateApplicantRequest(
        String userName,
        String name,
        String surname,
        String eMail,
        String phoneNumber,
        String address,
        String email) {
}
