package app.handicraft.model.user;

import app.handicraft.model.handicraft.Handicraft;
import app.handicraft.model.handicraft.HandicraftType;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Instructor extends User {
    private Float weekdayFee;
    private Float weekendFee;
    @ElementCollection
    private List<DayOfWeek> days;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "instructor_handicraft_type", // Name of the join table
            joinColumns = @JoinColumn(name = "instructor_id"), // Column in the join table that references the instructor
            inverseJoinColumns = @JoinColumn(name = "handicraft_type_id") // Column in the join table that references the course type
    )
    private List<HandicraftType> handicraftTypeList;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "handicraft_id")
    private List<Handicraft> handicrafts;
    public Instructor(String userName, String name, String surname, String eMail, String phoneNumber, String address,Float weekdayFee, Float weekendFee) {
        super(userName, name, surname, eMail, phoneNumber, address);
        this.handicraftTypeList = new ArrayList<>();
        this.weekdayFee = weekdayFee;
        this.weekendFee = weekendFee;
        this.days = new ArrayList<>();
        this.handicrafts = new ArrayList<>();
    }

    public Instructor() {
    }

    public List<Handicraft> getHandicrafts() {
        return handicrafts;
    }

    public void setHandicrafts(List<Handicraft> handicrafts) {
        this.handicrafts = handicrafts;
    }

    public List<DayOfWeek> getDays() {
        return days;
    }

    public void setDays(List<DayOfWeek> days) {
        this.days = days;
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


    public List<HandicraftType> getHandicraftTypeList() {
        return handicraftTypeList;
    }

    public void setHandicraftTypeList(List<HandicraftType> handicraftTypeList) {
        this.handicraftTypeList = handicraftTypeList;
    }
}
