package app.handicraft.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Course {
    @Id
    private UUID id;
    private String name;
    private Instant createInstant;
    private Instant closeInstant;
    private Boolean isActive;
    private Double baseCourseFee;
    private Double currentCourseFee;
    @OneToMany
    @JoinColumn(name = "applicant_id")
    private List<Applicant> applicants;
    @ManyToOne
    @JoinColumn(name = "course_type_id")
    private CourseType courseType;
    public Course(String name, CourseType courseType, Double baseCourseFee) {
        this.name = name;
        this.courseType = courseType;
        this.baseCourseFee = baseCourseFee;
        this.isActive = true;
        this.createInstant = Instant.now();
        this.applicants = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getCreateInstant() {
        return createInstant;
    }

    public void setCreateInstant(Instant createInstant) {
        this.createInstant = createInstant;
    }

    public Instant getCloseInstant() {
        return closeInstant;
    }

    public void setCloseInstant(Instant closeInstant) {
        this.closeInstant = closeInstant;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public Double getBaseCourseFee() {
        return baseCourseFee;
    }

    public void setBaseCourseFee(Double baseCourseFee) {
        this.baseCourseFee = baseCourseFee;
    }

    public Double getCurrentCourseFee() {
        return currentCourseFee;
    }

    public void setCurrentCourseFee(Double currentCourseFee) {
        this.currentCourseFee = currentCourseFee;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Applicant> applicants) {
        this.applicants = applicants;
    }
}
