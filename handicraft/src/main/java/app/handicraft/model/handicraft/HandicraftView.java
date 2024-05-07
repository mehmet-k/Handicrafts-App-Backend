package app.handicraft.model.handicraft;

import app.handicraft.model.course.Course;
import app.handicraft.model.user.Instructor;

import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;

public record HandicraftView(UUID id, Float fee, HandicraftType handicraftType, Instructor instructor, Course course,
                             List<DayOfWeek> days) {

}
