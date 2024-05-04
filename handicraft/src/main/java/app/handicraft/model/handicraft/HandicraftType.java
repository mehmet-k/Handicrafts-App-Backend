package app.handicraft.model.handicraft;

import app.handicraft.model.course.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class HandicraftType {

    @Id
    private UUID id;
    private String name;
    private String explanation;
    @OneToMany
    @JoinColumn(name = "handicraft_id")
    private List<Handicraft> handicrafts ;

    public HandicraftType(String name, String explanation) {
        this.name = name;
        this.explanation = explanation;
        this.handicrafts = new ArrayList<>();
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
}
