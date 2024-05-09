package app.handicraft.model.handicraft;

import app.handicraft.model.course.Course;
import app.handicraft.model.user.Instructor;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class HandicraftType {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String explanation;
    @OneToMany(mappedBy = "handicraftType",fetch = FetchType.LAZY)
    private List<Handicraft> handicrafts ;
    @ManyToMany(mappedBy = "handicraftTypeList")
    private List<Instructor> instructors;

    public HandicraftType(String name, String explanation) {
        this.name = name;
        this.explanation = explanation;
        this.handicrafts = new ArrayList<>();
        this.instructors = new ArrayList<>();
    }

    public HandicraftType() {
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

    public List<Handicraft> getHandicrafts() {
        return handicrafts;
    }

    public void setHandicrafts(List<Handicraft> handicrafts) {
        this.handicrafts = handicrafts;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }
}
