package app.handicraft.service;

import app.handicraft.model.handicraft.HandicraftType;
import app.handicraft.repository.HandicraftTypeRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HandicraftTypeService {

    private final HandicraftTypeRepository handicraftTypeRepository;

    public HandicraftTypeService(HandicraftTypeRepository handicraftTypeRepository) {
        this.handicraftTypeRepository = handicraftTypeRepository;
    }

    public HandicraftType getHandicraftById(UUID id){
        return handicraftTypeRepository.findById(id).orElseThrow(()->new RuntimeException("Handicraft type doesn't exists with this ID"));
    }
}
