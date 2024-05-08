package app.handicraft.dto.createHandicraft;

import app.handicraft.model.handicraft.HandicraftView;

import java.util.UUID;

public record CreateHandicraftResponse(
        UUID id,
        String name,
        Boolean isWeekend
) {
}
