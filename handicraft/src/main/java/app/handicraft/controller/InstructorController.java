package app.handicraft.controller;

import app.handicraft.dto.createInstructor.CreateInstructorRequest;
import app.handicraft.dto.createInstructor.CreateInstructorResponse;
import app.handicraft.service.InstructorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    public ResponseEntity<CreateInstructorResponse> createInstructor(@RequestBody CreateInstructorRequest createInstructorRequest){
        return null;
    }

    public void getInstructorById(){};

    public void getInstructorByUserName(){};
    public void getAvailableDays(){};
}

