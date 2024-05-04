package app.handicraft.model.user;

import app.handicraft.model.course.Course;
import app.handicraft.model.relation.ApplicantAttends;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

public class Applicant extends User {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_attends_id")
    private List<ApplicantAttends> applicantAttends;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private List<Course> courses;

    public Applicant(String userName, String name, String surname, String eMail, String phoneNumber, String address) {
        super(userName, name, surname, eMail, phoneNumber, address);
        applicantAttends = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<ApplicantAttends> getApplicantAttends() {
        return applicantAttends;
    }

    public void setApplicantAttends(List<ApplicantAttends> applicantAttends) {
        this.applicantAttends = applicantAttends;
    }
}
