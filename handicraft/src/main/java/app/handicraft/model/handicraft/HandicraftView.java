package app.handicraft.model.handicraft;

import app.handicraft.model.course.Course;
import app.handicraft.model.course.CourseView;
import app.handicraft.model.user.Instructor;
import app.handicraft.model.user.InstructorView;

import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;

public record HandicraftView(
        UUID id,
        Float fee,
        String handicraftTypeName,
        String instructorName,
        String day
) {

}
