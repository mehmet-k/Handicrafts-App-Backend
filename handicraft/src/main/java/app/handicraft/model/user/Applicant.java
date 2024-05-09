package app.handicraft.model.user;

import app.handicraft.model.relation.ApplicantParticipation;
import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Applicant extends User {
    @OneToMany(mappedBy = "applicant",fetch = FetchType.EAGER)
    private List<ApplicantParticipation> applicantParticipationList;
    @ElementCollection
    private List<DayOfWeek> days;
    public Applicant(String userName, String name, String surname, String eMail, String phoneNumber, String address) {
        super(userName, name, surname, eMail, phoneNumber, address);
        this.applicantParticipationList = new ArrayList<>();
        this.days = new ArrayList<>();
    }

    public Applicant() {
    }

    public List<DayOfWeek> getDays() {
        return days;
    }

    public void setDays(List<DayOfWeek> days) {
        this.days = days;
    }

    public List<ApplicantParticipation> getApplicantAttendsList() {
        return applicantParticipationList;
    }

    public void setApplicantAttendsList(List<ApplicantParticipation> applicantParticipationList) {
        this.applicantParticipationList = applicantParticipationList;
    }

}
