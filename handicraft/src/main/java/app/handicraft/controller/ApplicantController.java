package app.handicraft.controller;

import app.handicraft.dto.createApplicant.CreateApplicantRequest;
import app.handicraft.dto.createApplicant.CreateApplicantResponse;
import app.handicraft.dto.updateApplicant.UpdateApplicantRequest;
import app.handicraft.dto.updateApplicant.UpdateApplicantResponse;
import app.handicraft.model.course.CourseView;
import app.handicraft.model.user.Applicant;
import app.handicraft.model.user.ApplicantView;
import app.handicraft.model.user.UserView;
import app.handicraft.service.ApplicantParticipationService;
import app.handicraft.service.ApplicantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    private final ApplicantService applicantService;

    private final ApplicantParticipationService applicantParticipationService;

    public ApplicantController(ApplicantService applicantService, ApplicantParticipationService applicantParticipationService) {
        this.applicantService = applicantService;
        this.applicantParticipationService = applicantParticipationService;
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
        return applicantParticipationService.getApplicantCourseViews(applicant);
    }

    @GetMapping("/viewAll")
    public List<ApplicantView> getAllApplicantsView(){
        List<ApplicantView> applicantViews = new ArrayList<>();
        List<UserView> userViews = applicantService.getAllApplicantsView(applicantService.getAllApplicants());
        for(UserView u:userViews){
            applicantViews.add(new ApplicantView(u,applicantParticipationService
                    .getApplicantCourseViews(applicantService.getApplicantById(u.id()))));
        }
        return applicantViews;
    }

    /*
    public ResponseEntity<ApplicantLoginResponse> checkApplicantCredentials(@RequestBody ApplicantLoginRequest){

    }
*/
}
