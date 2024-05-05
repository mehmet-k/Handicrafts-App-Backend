package app.handicraft.model.relation;

import app.handicraft.model.handicraft.Handicraft;
import app.handicraft.model.user.Instructor;
import app.handicraft.util.AttendanceStatus;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class InstructorAttends {

    @Id
    private UUID id;
    private Float instructorFee;
    private AttendanceStatus applicationStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "handicraft_id")
    private Handicraft handicraft;

    public InstructorAttends(Float instructorFee, AttendanceStatus applicationStatus, Instructor instructor, Handicraft handicraft) {
        this.instructorFee = instructorFee;
        this.applicationStatus = applicationStatus;
        this.instructor = instructor;
        this.handicraft = handicraft;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Float getInstructorFee() {
        return instructorFee;
    }

    public void setInstructorFee(Float instructorFee) {
        this.instructorFee = instructorFee;
    }

    public AttendanceStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(AttendanceStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Handicraft getHandicraft() {
        return handicraft;
    }

    public void setHandicraft(Handicraft handicraft) {
        this.handicraft = handicraft;
    }
}
