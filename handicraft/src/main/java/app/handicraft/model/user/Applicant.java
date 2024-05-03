package app.handicraft.model.user;

import app.handicraft.model.relation.ApplicantAttends;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

public class Applicant extends User {

    @ManyToOne
    @JoinColumn(name = "applicant_attends_id")
    private List<ApplicantAttends> applicantAttends;

    public Applicant(String userName, String name, String surname, String eMail, String phoneNumber, String address) {
        super(userName, name, surname, eMail, phoneNumber, address);
        applicantAttends = new ArrayList<>();
    }

    public List<ApplicantAttends> getApplicantAttends() {
        return applicantAttends;
    }

    public void setApplicantAttends(List<ApplicantAttends> applicantAttends) {
        this.applicantAttends = applicantAttends;
    }
}
