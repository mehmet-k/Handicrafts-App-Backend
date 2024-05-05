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
    private Float weekdayFee;
    private Float weekendFee;
    @ManyToMany
    @JoinTable(
            name = "instructor_handicraft_type", // Name of the join table
            joinColumns = @JoinColumn(name = "instructor_id"), // Column in the join table that references the instructor
            inverseJoinColumns = @JoinColumn(name = "handicraft_type_id") // Column in the join table that references the course type
    )
    private List<HandicraftType> handicraftTypeList;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_attends_id")
    private List<InstructorAttends> instructorAttends;
    public Instructor(String userName, String name, String surname, String eMail, String phoneNumber, String address,Float weekdayFee, Float weekendFee) {
        super(userName, name, surname, eMail, phoneNumber, address);
        this.handicraftTypeList = new ArrayList<>();
        this.instructorAttends = new ArrayList<>();
        this.weekdayFee = weekdayFee;
        this.weekendFee = weekendFee;
    }

    public Float getWeekdayFee() {
        return weekdayFee;
    }

    public void setWeekdayFee(Float weekdayFee) {
        this.weekdayFee = weekdayFee;
    }

    public Float getWeekendFee() {
        return weekendFee;
    }

    public void setWeekendFee(Float weekendFee) {
        this.weekendFee = weekendFee;
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
