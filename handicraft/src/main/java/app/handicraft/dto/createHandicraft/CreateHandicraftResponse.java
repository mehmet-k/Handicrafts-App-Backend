package app.handicraft.dto.createHandicraft;

import app.handicraft.model.handicraft.Handicraft;

import java.util.UUID;

public record CreateHandicraftResponse(
        Handicraft handicraft
) {
}
