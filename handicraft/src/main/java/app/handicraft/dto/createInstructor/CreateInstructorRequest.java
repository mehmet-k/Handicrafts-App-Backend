package app.handicraft.dto.createInstructor;

public record CreateInstructorRequest(
        String userName,
        String name,
        String surname,
        String eMail,
        String phoneNumber,
        String address,
        Float  weekdayFee,
        Float  weekendFee
) {
}
