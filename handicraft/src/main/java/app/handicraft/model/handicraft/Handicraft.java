package app.handicraft.model.handicraft;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Handicraft {

    @Id
    private UUID id;
    private Float fee;
    @ManyToOne
    @JoinColumn(name = "handicraft_type_id")
    private List<HandicraftType> handicraftTypes;

    public Handicraft(Float fee) {
        this.fee = fee;
        this.handicraftTypes = new ArrayList<>();
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

    public List<HandicraftType> getHandicraftTypes() {
        return handicraftTypes;
    }

    public void setHandicraftTypes(List<HandicraftType> handicraftTypes) {
        this.handicraftTypes = handicraftTypes;
    }
}
