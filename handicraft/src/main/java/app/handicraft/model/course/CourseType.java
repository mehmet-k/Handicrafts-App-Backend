package app.handicraft.model.course;

import app.handicraft.model.course.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class CourseType {

    @Id
    private UUID id;
    private String name;
    private String explanation;
    @OneToMany
    @JoinColumn(name = "course_id")
    private List<Course> courseList;

    public CourseType(String name, String explanation) {
        this.name = name;
        this.explanation = explanation;
        this.courseList = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
