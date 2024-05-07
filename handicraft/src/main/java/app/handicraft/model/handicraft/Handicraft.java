package app.handicraft.model.handicraft;

import app.handicraft.model.course.Course;
import app.handicraft.model.user.Instructor;
import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Handicraft {
    @Id
    private UUID id;
    private Float fee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "handicraft_type_id")
    private HandicraftType handicraftType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
    @ElementCollection
    private List<DayOfWeek> days;

    public Handicraft(Float fee, HandicraftType handicraftType,Course course) {
        this.fee = fee;
        this.handicraftType = handicraftType;
        this.days = new ArrayList<>();
        this.course = course;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<DayOfWeek> getDays() {
        return days;
    }

    public void setDays(List<DayOfWeek> days) {
        this.days = days;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public HandicraftType getHandicraftType() {
        return handicraftType;
    }

    public void setHandicraftType(HandicraftType handicraftType) {
        this.handicraftType = handicraftType;
    }
}
