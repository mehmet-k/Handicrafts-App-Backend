package app.handicraft.dto.createInstructor;

import app.handicraft.model.handicraft.HandicraftType;

import java.util.List;
import java.util.UUID;

public record CreateInstructorRequest(
        String userName,
        String name,
        String surname,
        String eMail,
        String phoneNumber,
        String address,
        Float  weekdayFee,
        Float  weekendFee,
        List<UUID> handicraftTypeIds
) {
}
