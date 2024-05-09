package app.handicraft.controller;

import app.handicraft.dto.createHandicraftType.CreateHandicraftTypeRequest;
import app.handicraft.dto.createHandicraftType.CreateHandicraftTypeResponse;
import app.handicraft.model.handicraft.Handicraft;
import app.handicraft.model.handicraft.HandicraftType;
import app.handicraft.model.handicraft.HandicraftTypeView;
import app.handicraft.service.HandicraftTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/handicraftType")
public class HandicraftTypeController {

    private final HandicraftTypeService handicraftTypeService;

    public HandicraftTypeController(HandicraftTypeService handicraftTypeService) {
        this.handicraftTypeService = handicraftTypeService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<CreateHandicraftTypeResponse> createHandicraftType(@RequestBody CreateHandicraftTypeRequest createHandicraftTypeRequest){
        var handicraftType = handicraftTypeService.addHandicraft(createHandicraftTypeRequest);
        return new ResponseEntity<>(new CreateHandicraftTypeResponse(handicraftType.getId()), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/allView")
    public List<HandicraftTypeView> getAllHandicraftsView(){
        return handicraftTypeService.getAllHandicraftTypeViews(handicraftTypeService.getAllHandicraftTypes());
    }
}
