package app.handicraft.model.course;

import app.handicraft.model.handicraft.HandicraftType;
import app.handicraft.model.relation.ApplicantAttends;
import app.handicraft.model.user.Applicant;
import app.handicraft.model.user.Instructor;
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
    private Float baseCourseFee;
    private Float currentCourseFee;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_attends_id")
    private List<ApplicantAttends> applicantAttends;
    public Course(String name, HandicraftType courseType, Float baseCourseFee) {
        this.name = name;
        this.baseCourseFee = baseCourseFee;
        this.isActive = true;
        this.createInstant = Instant.now();
        this.applicantAttends = new ArrayList<>();
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

    public Float getBaseCourseFee() {
        return baseCourseFee;
    }

    public void setBaseCourseFee(Float baseCourseFee) {
        this.baseCourseFee = baseCourseFee;
    }

    public Float getCurrentCourseFee() {
        return currentCourseFee;
    }

    public void setCurrentCourseFee(Float currentCourseFee) {
        this.currentCourseFee = currentCourseFee;
    }

    public List<ApplicantAttends> getApplicantAttends() {
        return applicantAttends;
    }

    public void setApplicantAttends(List<ApplicantAttends> applicantAttends) {
        this.applicantAttends = applicantAttends;
    }


}
