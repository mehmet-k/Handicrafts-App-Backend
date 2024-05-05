package app.handicraft.dto.createHandicraft;

import app.handicraft.model.handicraft.HandicraftType;

import java.util.UUID;

public record CreateHandicraftRequest(
        Float fee,
        UUID handicraftTypeId
) {
}
