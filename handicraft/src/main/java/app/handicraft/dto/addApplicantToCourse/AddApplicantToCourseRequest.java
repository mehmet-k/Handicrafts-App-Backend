package app.handicraft.dto.addApplicantToCourse;

import java.util.UUID;

public record AddApplicantToCourseRequest(
        UUID courseId,
        UUID applicantId
) {
}
