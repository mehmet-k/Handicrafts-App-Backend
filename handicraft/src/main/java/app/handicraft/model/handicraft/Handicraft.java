package app.handicraft.model.handicraft;

import app.handicraft.model.relation.InstructorAttends;
import app.handicraft.model.user.Instructor;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Handicraft {
    @Id
    private UUID id;
    private Float fee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "handicraft_type_id")
    private HandicraftType handicraftType;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_attends_id")
    private List<InstructorAttends> instructorAttends;

    public Handicraft(Float fee, HandicraftType handicraftType) {
        this.fee = fee;
        this.handicraftType = handicraftType;
        this.instructorAttends = new ArrayList<>();
    }

    public List<InstructorAttends> getInstructorAttends() {
        return instructorAttends;
    }

    public void setInstructorAttends(List<InstructorAttends> instructorAttends) {
        this.instructorAttends = instructorAttends;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public HandicraftType getHandicraftType() {
        return handicraftType;
    }

    public void setHandicraftType(HandicraftType handicraftType) {
        this.handicraftType = handicraftType;
    }
}
