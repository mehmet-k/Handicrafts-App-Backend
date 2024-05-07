package app.handicraft.model.course;

import app.handicraft.model.handicraft.Handicraft;
import app.handicraft.model.relation.ApplicantParticipation;
import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class CourseView {
    @Id
    private final UUID id;
    private final String name;
    private final Float currentCourseFee;
    private final Integer maxAttendants;
    private final Integer attendantCount;
    private final List<Handicraft> handicrafts;
    private final List<DayOfWeek> days;

    public CourseView(UUID id, String name, Float currentCourseFee, Integer maxAttendants, Integer attendantCount, List<Handicraft> handicrafts, List<DayOfWeek> days) {
        this.id = id;
        this.name = name;
        this.currentCourseFee = currentCourseFee;
        this.maxAttendants = maxAttendants;
        this.attendantCount = attendantCount;
        this.handicrafts = handicrafts;
        this.days = days;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getCurrentCourseFee() {
        return currentCourseFee;
    }

    public Integer getMaxAttendants() {
        return maxAttendants;
    }

    public Integer getAttendantCount() {
        return attendantCount;
    }

    public List<Handicraft> getHandicrafts() {
        return handicrafts;
    }

    public List<DayOfWeek> getDays() {
        return days;
    }
}
