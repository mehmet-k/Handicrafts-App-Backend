package app.handicraft.model.course;

import app.handicraft.model.handicraft.Handicraft;
import app.handicraft.model.handicraft.HandicraftType;
import app.handicraft.model.relation.ApplicantParticipation;
import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private Instant createInstant;
    private Instant closeInstant;
    private Boolean isActive;
    private Float baseCourseFee;
    private Float currentCourseFee;
    private Integer maxAttendants;
    private Integer attendantCount;
    @OneToMany(mappedBy = "applicant",fetch = FetchType.EAGER)
    private List<ApplicantParticipation> applicantParticipationList;
    @OneToMany(mappedBy = "course",fetch = FetchType.EAGER)
    private List<Handicraft> handicrafts;
    @ElementCollection
    private List<DayOfWeek> days;
    public Course(String name, Float baseCourseFee, Integer maxAttendants) {
        this.name = name;
        this.baseCourseFee = baseCourseFee;
        this.isActive = true;
        this.createInstant = Instant.now();
        this.applicantParticipationList = new ArrayList<>();
        this.maxAttendants = maxAttendants;
        this.attendantCount = 0;
        this.handicrafts = new ArrayList<>();
        this.days = new ArrayList<>();
    }

    public Course() {
    }

    public List<DayOfWeek> getDays() {
        return days;
    }

    public void setDays(List<DayOfWeek> days) {
        this.days = days;
    }

    public List<Handicraft> getHandicrafts() {
        return handicrafts;
    }

    public void setHandicrafts(List<Handicraft> handicrafts) {
        this.handicrafts = handicrafts;
    }

    public Integer getAttendantCount() {
        return attendantCount;
    }

    public void setAttendantCount(Integer attendantCount) {
        this.attendantCount = attendantCount;
    }

    public Integer getMaxAttendants() {
        return maxAttendants;
    }

    public void setMaxAttendants(Integer maxAttendants) {
        this.maxAttendants = maxAttendants;
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

    public List<ApplicantParticipation> getApplicantAttendsList() {
        return applicantParticipationList;
    }

    public void setApplicantAttendsList(List<ApplicantParticipation> applicantParticipationList) {
        this.applicantParticipationList = applicantParticipationList;
    }


}
