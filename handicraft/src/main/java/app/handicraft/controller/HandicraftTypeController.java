package app.handicraft.controller;

import app.handicraft.dto.createHandicraftType.CreateHandicraftTypeRequest;
import app.handicraft.dto.createHandicraftType.CreateHandicraftTypeResponse;
import app.handicraft.service.HandicraftTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/handicraftType")
public class HandicraftTypeController {

    private final HandicraftTypeService handicraftTypeService;

    public HandicraftTypeController(HandicraftTypeService handicraftTypeService) {
        this.handicraftTypeService = handicraftTypeService;
    }

    @PostMapping
    public ResponseEntity<CreateHandicraftTypeResponse> createHandicraftType(@RequestBody CreateHandicraftTypeRequest createHandicraftTypeRequest){
        var handicraftType = handicraftTypeService.addHandicraft(createHandicraftTypeRequest);
        return new ResponseEntity<>(new CreateHandicraftTypeResponse(handicraftType.getId()), HttpStatus.CREATED);
    }
}
