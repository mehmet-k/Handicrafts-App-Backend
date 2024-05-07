package app.handicraft.controller;

import app.handicraft.dto.createApplicant.CreateApplicantRequest;
import app.handicraft.dto.createApplicant.CreateApplicantResponse;
import app.handicraft.dto.updateApplicant.UpdateApplicantRequest;
import app.handicraft.dto.updateApplicant.UpdateApplicantResponse;
import app.handicraft.model.course.CourseView;
import app.handicraft.model.user.Applicant;
import app.handicraft.service.ApplicantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    private final ApplicantService applicantService;
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping
    public ResponseEntity<CreateApplicantResponse> createApplicant(@RequestBody CreateApplicantRequest createApplicantRequest){
        var applicant = applicantService.addApplicant(createApplicantRequest);
        return new ResponseEntity<>(new CreateApplicantResponse(applicant.getUserName(),applicant.getId()), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateApplicantResponse> updateApplicant(@RequestBody UpdateApplicantRequest updateApplicantRequest,@PathVariable UUID id){
        var applicant = applicantService.updateApplicant(updateApplicantRequest,id);
        return new ResponseEntity<>(new UpdateApplicantResponse(applicant.getId(),applicant.getUserName()),HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public Applicant getApplicantById(@PathVariable UUID id){
       return applicantService.getApplicantById(id);
    }

    @GetMapping("/userName/{userName}")
    public Applicant getApplicantByUserName(@PathVariable String userName){
        return applicantService.getApplicantByUserName(userName);
    }
    @GetMapping("/{id}/courses")
    public List<CourseView> getApplicantCourses(@PathVariable UUID id){
        var applicant = applicantService.getApplicantById(id);
        return applicantService.getApplicantCourseViews(applicant);
    }
    
}
