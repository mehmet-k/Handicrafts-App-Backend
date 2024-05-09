package app.handicraft.dto.addApplicantToCourse;

import java.util.UUID;

public record AddApplicantToCourseResponse (
        UUID courseId,
        UUID applicantId
){
}
