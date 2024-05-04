package app.handicraft.model.user;

import app.handicraft.model.course.Course;
import app.handicraft.model.relation.ApplicantAttends;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Applicant extends User {
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_attends_id")
    private List<ApplicantAttends> applicantAttends;

    public Applicant(String userName, String name, String surname, String eMail, String phoneNumber, String address) {
        super(userName, name, surname, eMail, phoneNumber, address);
        this.applicantAttends = new ArrayList<>();
    }

    public List<ApplicantAttends> getApplicantAttends() {
        return applicantAttends;
    }

    public void setApplicantAttends(List<ApplicantAttends> applicantAttends) {
        this.applicantAttends = applicantAttends;
    }

}
