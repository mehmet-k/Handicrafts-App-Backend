package app.handicraft.model.relation;

import app.handicraft.model.course.Course;
import app.handicraft.model.user.Applicant;
import app.handicraft.util.AttendanceStatus;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class ApplicantAttends {
    @Id
    private UUID id;
    private Float fee;
    private AttendanceStatus applicationStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course courses;

    public ApplicantAttends(Float fee, AttendanceStatus applicationStatus, Applicant applicant, Course courses) {
        this.fee = fee;
        this.applicationStatus = applicationStatus;
        this.applicant = applicant;
        this.courses = courses;
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

    public AttendanceStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(AttendanceStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Course getCourses() {
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }
}
