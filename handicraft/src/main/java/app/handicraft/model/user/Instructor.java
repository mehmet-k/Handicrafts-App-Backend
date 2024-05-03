package app.handicraft.model.user;

import app.handicraft.model.relation.ApplicantAttends;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Instructor extends User {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_attends_id")
    List<ApplicantAttends> applicantAttends;
    public Instructor(String userName, String name, String surname, String eMail, String phoneNumber, String address) {
        super(userName, name, surname, eMail, phoneNumber, address);
        this.applicantAttends = new ArrayList<>();
    }


}
