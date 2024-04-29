package app.handicraft.model;

import java.util.HashMap;
import java.util.Map;

public class Applicant extends User{

    private Map<Course,Double> courseMap;
    private Map<Course,Double> prevAttendedCourseMap;
    private Map<Course,Double> willAttendCourseMap;

    public Applicant(String userName, String name, String surname, String eMail, String phoneNumber) {
        super(userName, name, surname, eMail, phoneNumber);
        courseMap = new HashMap<>();
        prevAttendedCourseMap = new HashMap<>();
        willAttendCourseMap = new HashMap<>();
    }

    public Map<Course, Double> getCourseMap() {
        return courseMap;
    }

    public void setCourseMap(Map<Course, Double> courseMap) {
        this.courseMap = courseMap;
    }

    public Map<Course, Double> getPrevAttendedCourseMap() {
        return prevAttendedCourseMap;
    }

    public void setPrevAttendedCourseMap(Map<Course, Double> prevAttendedCourseMap) {
        this.prevAttendedCourseMap = prevAttendedCourseMap;
    }

    public Map<Course, Double> getWillAttendCourseMap() {
        return willAttendCourseMap;
    }

    public void setWillAttendCourseMap(Map<Course, Double> willAttendCourseMap) {
        this.willAttendCourseMap = willAttendCourseMap;
    }
}
