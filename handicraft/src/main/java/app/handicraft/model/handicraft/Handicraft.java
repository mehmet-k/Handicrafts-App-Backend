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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "handicraft_type_id")
    private HandicraftType handicraftType;

    public Handicraft(Float fee, HandicraftType handicraftType) {
        this.fee = fee;
        this.handicraftType = handicraftType;
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
