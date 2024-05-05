package app.handicraft.controller;

import app.handicraft.dto.createHandicraft.CreateHandicraftRequest;
import app.handicraft.dto.createHandicraft.CreateHandicraftResponse;
import app.handicraft.model.handicraft.Handicraft;
import app.handicraft.service.HandicraftService;
import app.handicraft.service.HandicraftTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/handicraft")
public class HandicraftController {

    private final HandicraftService handicraftService;
    private final HandicraftTypeService handicraftTypeService;

    public HandicraftController(HandicraftService handicraftService, HandicraftTypeService handicraftTypeService) {
        this.handicraftService = handicraftService;
        this.handicraftTypeService = handicraftTypeService;
    }

    @PostMapping
    public ResponseEntity<CreateHandicraftResponse> createHandicraft(@RequestBody CreateHandicraftRequest createHandicraftRequest){
        //var handicraft = handicraftService.addHandicraft(createHandicraftRequest);
        //return new ResponseEntity<>(new CreateHandicraftResponse(handicraft), HttpStatus.CREATED);
        return null;
    }

    @GetMapping("/get/{id}")
    public Handicraft getHandicraftById(@PathVariable UUID id){
        return null;
    }

}
