package app.handicraft.model.user;

import app.handicraft.model.course.Course;
import app.handicraft.model.relation.ApplicantAttends;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Instructor extends User {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_attends_id")
    List<ApplicantAttends> applicantAttends;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    List<Course> courses;

    public Instructor(String userName, String name, String surname, String eMail, String phoneNumber, String address) {
        super(userName, name, surname, eMail, phoneNumber, address);
        this.applicantAttends = new ArrayList<>();
        this.courses = new ArrayList<>();
    }
}
