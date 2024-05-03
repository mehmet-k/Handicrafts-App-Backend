package app.handicraft.model.relation;

import app.handicraft.model.course.Course;
import app.handicraft.model.user.Applicant;
import app.handicraft.model.user.Instructor;
import app.handicraft.util.AttendanceStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class ApplicantAttends {

    @Id
    UUID id;
    Float fee;
    AttendanceStatus applicationStatus;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    List<Instructor> instructors;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_id")
    List<Applicant> applicants;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    List<Course> courses;
    public ApplicantAttends(Float fee, AttendanceStatus applicationStatus) {
        this.fee = fee;
        this.applicationStatus = applicationStatus;
        this.applicants = new ArrayList<>();
        this.instructors = new ArrayList<>();
        this.courses = new ArrayList<>();
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

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Applicant> applicants) {
        this.applicants = applicants;
    }
}
