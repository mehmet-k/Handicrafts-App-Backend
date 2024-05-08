package app.handicraft.model.handicraft;

import java.util.UUID;

public record HandicraftTypeView(
        UUID id,
        String name,
        String explanation
) {
}
