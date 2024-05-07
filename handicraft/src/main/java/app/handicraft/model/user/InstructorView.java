package app.handicraft.model.user;

import jakarta.persistence.ElementCollection;

import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;

public record InstructorView(
        UUID id,
        String userName,
        String name,
        String surname,
        String eMail,
        String phoneNumber,
        String address,
        Float weekdayFee,
        Float weekendFee,
        List<DayOfWeek>days) {
}
