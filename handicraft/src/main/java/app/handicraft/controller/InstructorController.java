package app.handicraft.controller;

import app.handicraft.dto.createInstructor.CreateInstructorRequest;
import app.handicraft.dto.createInstructor.CreateInstructorResponse;
import app.handicraft.model.user.InstructorView;
import app.handicraft.service.InstructorService;
import app.handicraft.util.Days;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public ResponseEntity<CreateInstructorResponse> createInstructor(@RequestBody CreateInstructorRequest createInstructorRequest){
        var instructor = instructorService.addInstructor(createInstructorRequest);
        return new ResponseEntity<>(new CreateInstructorResponse(instructor.getUserName(),instructor.getId()), HttpStatus.CREATED);
    }

    @GetMapping("/view/id/{id}")
    public InstructorView getInstructorViewById(@PathVariable UUID id){
        return instructorService.convertInstructorToView(instructorService.getInstructorById(id));
    }

    @GetMapping("/availableDays{id}")
    public List<String> getAvailableDays(@PathVariable UUID id){
        var instructor = instructorService.getInstructorById(id);
        return Days.convertDaysEnumListToStringList(instructorService.getAvailableInstructorDays(instructor));
    }

    @GetMapping("/viewAll")
    public List<InstructorView> getAllInstructorViews(){
        return instructorService.convertInstructorListToInstructorViewList(instructorService.getAllInstructors());
    }
}

