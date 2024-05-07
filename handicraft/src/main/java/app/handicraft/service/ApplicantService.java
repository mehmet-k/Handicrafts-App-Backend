package app.handicraft.service;

import app.handicraft.dto.createApplicant.CreateApplicantRequest;
import app.handicraft.dto.updateApplicant.UpdateApplicantRequest;
import app.handicraft.model.course.Course;
import app.handicraft.model.course.CourseView;
import app.handicraft.model.relation.ApplicantParticipation;
import app.handicraft.model.user.Applicant;
import app.handicraft.repository.ApplicantParticipationRepository;
import app.handicraft.repository.ApplicantRepository;
import app.handicraft.util.AttendanceStatus;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;
    private final ApplicantParticipationRepository applicantParticipationRepository;

    public ApplicantService(ApplicantRepository applicantRepository, ApplicantParticipationRepository applicantParticipationRepository) {
        this.applicantRepository = applicantRepository;
        this.applicantParticipationRepository = applicantParticipationRepository;
    }

    public Applicant addApplicant(CreateApplicantRequest createApplicantRequest){
        if(createApplicantRequest==null){
            throw new RuntimeException();
        }
        var applicant = new Applicant(createApplicantRequest.userName(), createApplicantRequest.surname(), createApplicantRequest.name(),createApplicantRequest.surname(),
                createApplicantRequest.phoneNumber(),createApplicantRequest.address());
        return applicantRepository.save(applicant);
    }

    public Applicant updateApplicant(UpdateApplicantRequest updateApplicantRequest,UUID id){
        if(updateApplicantRequest==null){
            throw new RuntimeException();
        }
        var applicant = applicantRepository.findById(id).orElseThrow(()-> new RuntimeException("Applicant with this ID doesn't exists"));
        applicant.setUserName(updateApplicantRequest.userName());
        applicant.setName(updateApplicantRequest.name());
        applicant.setSurname(updateApplicantRequest.surname());
        applicant.setPhoneNumber(updateApplicantRequest.phoneNumber());
        applicant.setAddress(updateApplicantRequest.address());
        applicant.seteMail(updateApplicantRequest.eMail());
        return applicantRepository.save(applicant);
    }
    public Applicant updateApplicant(Applicant applicant){
        if(applicant == null){
            throw new RuntimeException("Applicant is null");
        }
        return applicantRepository.save(applicant);
    }
    public Applicant getApplicantById(UUID id){
        return applicantRepository.findById(id).orElseThrow(()->new RuntimeException("Applicant with this ID doesn't exists"));
    }

    public Applicant getApplicantByUserName(String userName){
        return applicantRepository.findApplicantByUserName(userName)
                .orElseThrow(()->new RuntimeException("Applicant with user name ID doesn't exists"));
    }

    public ApplicantParticipation addCourseToApplicant(Applicant applicant, Course course){
        if(applicant == null){
            throw new RuntimeException("Applicant is null");
        }
        if(course == null){
            throw new RuntimeException("Course is null");
        }
        if(applicantParticipationRepository.existsByApplicantAndCourse(applicant,course)){
            throw new RuntimeException("This applicant is already attending to the course");
        }
        for(DayOfWeek d: course.getDays()){
            if(applicant.getDays().contains(d)){
                throw new RuntimeException(STR."User program for\{d.name()}is not avaliable");
            }
            else{
                applicant.getDays().add(d);
            }
        }
        var applicantAttends = new ApplicantParticipation(course.getCurrentCourseFee(), AttendanceStatus.WILL_ATTEND);
        applicantParticipationRepository.save(applicantAttends);
        applicant.getApplicantAttendsList().add(applicantAttends);
        applicantRepository.save(applicant);
        return applicantAttends;
    }


    public Applicant clearSpecifiedDaysFromCalendar(Applicant applicant,List<DayOfWeek> days){
        if(applicant == null){
            throw new RuntimeException("applicant is null");
        }
        if(days == null){
            throw new RuntimeException("days are null");
        }
        for(DayOfWeek d:days){
            if(applicant.getDays().contains(d)){
                applicant.getDays().remove(d);
            }
            else{
                throw new RuntimeException(STR."applicant doesn't have day: \{d.name()}");
            }
        }
        return applicantRepository.save(applicant);
    }

}
