package app.handicraft.service;

import app.handicraft.dto.createApplicant.CreateApplicantRequest;
import app.handicraft.dto.updateApplicant.UpdateApplicantRequest;
import app.handicraft.model.user.Applicant;
import app.handicraft.repository.ApplicantRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;

    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public Applicant addApplicant(CreateApplicantRequest createApplicantRequest){
        return null;
    }

    public Applicant updateApplicant(UpdateApplicantRequest updateApplicantRequest){
        return null;
    }
}
