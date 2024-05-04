package app.handicraft.model.user;

import app.handicraft.model.course.Course;
import app.handicraft.model.handicraft.Handicraft;
import app.handicraft.model.handicraft.HandicraftType;
import app.handicraft.model.relation.ApplicantAttends;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Instructor extends User {
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "handicraft_type_list")
    private List<HandicraftType> handicraftTypeList;
    public Instructor(String userName, String name, String surname, String eMail, String phoneNumber, String address) {
        super(userName, name, surname, eMail, phoneNumber, address);
        this.handicraftTypeList = new ArrayList<>();
    }

    public List<HandicraftType> getHandicraftTypeList() {
        return handicraftTypeList;
    }

    public void setHandicraftTypeList(List<HandicraftType> handicraftTypeList) {
        this.handicraftTypeList = handicraftTypeList;
    }
}
