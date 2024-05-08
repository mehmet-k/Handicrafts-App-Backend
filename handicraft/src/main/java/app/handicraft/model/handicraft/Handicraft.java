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
    @GeneratedValue
    private UUID id;
    private Float fee;
    private Boolean isWeekend;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
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

    public Handicraft(Float fee, HandicraftType handicraftType,String name,Boolean isWeekend) {
        this.fee = fee;
        this.handicraftType = handicraftType;
        this.days = new ArrayList<>();
        this.name = name;
        this.isWeekend = isWeekend;
    }

    public Handicraft() {
    }

    public Boolean getWeekend() {
        return isWeekend;
    }

    public void setWeekend(Boolean weekend) {
        isWeekend = weekend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
