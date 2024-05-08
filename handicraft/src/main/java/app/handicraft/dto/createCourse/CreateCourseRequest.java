package app.handicraft.dto.createCourse;

import java.util.List;
import java.util.UUID;

public record CreateCourseRequest (
        String name,
        Integer capacity,
        List<UUID> handicraftIdList
){
}
