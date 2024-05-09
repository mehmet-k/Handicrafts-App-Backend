package app.handicraft.model.relation;

import app.handicraft.model.course.Course;
import app.handicraft.model.user.Applicant;
import app.handicraft.util.AttendanceStatus;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class ApplicantParticipation {
    @Id
    @GeneratedValue
    private UUID id;
    private Float fee;
    private AttendanceStatus attendanceStatus;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    public ApplicantParticipation(Float fee, AttendanceStatus attendanceStatus) {
        this.fee = fee;
        this.attendanceStatus = attendanceStatus;
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

    public AttendanceStatus getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(AttendanceStatus attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


}
