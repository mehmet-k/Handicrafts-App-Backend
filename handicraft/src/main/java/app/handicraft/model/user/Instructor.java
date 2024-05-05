package app.handicraft.model.user;

import app.handicraft.model.course.Course;
import app.handicraft.model.handicraft.Handicraft;
import app.handicraft.model.handicraft.HandicraftType;
import app.handicraft.model.relation.ApplicantAttends;
import app.handicraft.model.relation.InstructorAttends;
import com.sun.jdi.FloatType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Instructor extends User {
    private Float fee;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "handicraft_type_list")
    private List<HandicraftType> handicraftTypeList;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_attends_id")
    private List<InstructorAttends> instructorAttends;
    public Instructor(String userName, String name, String surname, String eMail, String phoneNumber, String address,Float fee) {
        super(userName, name, surname, eMail, phoneNumber, address);
        this.handicraftTypeList = new ArrayList<>();
        this.instructorAttends = new ArrayList<>();
        this.fee = fee;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public List<InstructorAttends> getInstructorAttends() {
        return instructorAttends;
    }

    public void setInstructorAttends(List<InstructorAttends> instructorAttends) {
        this.instructorAttends = instructorAttends;
    }

    public List<HandicraftType> getHandicraftTypeList() {
        return handicraftTypeList;
    }

    public void setHandicraftTypeList(List<HandicraftType> handicraftTypeList) {
        this.handicraftTypeList = handicraftTypeList;
    }
}
