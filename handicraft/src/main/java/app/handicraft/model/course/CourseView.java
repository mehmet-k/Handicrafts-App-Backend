package app.handicraft.model.course;

import app.handicraft.model.handicraft.HandicraftView;

import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;

public record CourseView(UUID id, String name, Float currentCourseFee, Integer maxAttendants, Integer attendantCount,
                         List<HandicraftView> handicrafts, List<DayOfWeek> days) {
}
