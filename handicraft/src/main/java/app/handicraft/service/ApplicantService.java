package app.handicraft.service;

import app.handicraft.dto.createApplicant.CreateApplicantRequest;
import app.handicraft.dto.updateApplicant.UpdateApplicantRequest;
import app.handicraft.model.course.Course;
import app.handicraft.model.relation.ApplicantAttends;
import app.handicraft.model.user.Applicant;
import app.handicraft.repository.ApplicantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;

    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public Applicant addApplicant(CreateApplicantRequest createApplicantRequest){
        if(createApplicantRequest==null){
            throw new RuntimeException();
        }
        var applicant = new Applicant(createApplicantRequest.userName(), createApplicantRequest.surname(), createApplicantRequest.name(),createApplicantRequest.surname(),
                createApplicantRequest.phoneNumber(),createApplicantRequest.address());
        return applicantRepository.save(applicant);
    }

    public Applicant updateApplicant(UpdateApplicantRequest updateApplicantRequest){
        if(updateApplicantRequest==null){
            throw new RuntimeException();
        }
        var applicant = applicantRepository.findById(updateApplicantRequest.id()).orElseThrow(RuntimeException::new);
        applicant.setUserName(updateApplicantRequest.userName());
        applicant.setName(updateApplicantRequest.name());
        applicant.setSurname(updateApplicantRequest.surname());
        applicant.setPhoneNumber(updateApplicantRequest.phoneNumber());
        applicant.setAddress(updateApplicantRequest.address());
        applicant.seteMail(updateApplicantRequest.eMail());
        return applicantRepository.save(applicant);
    }

}
