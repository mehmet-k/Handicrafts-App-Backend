package app.handicraft.service;

import app.handicraft.model.course.Course;
import app.handicraft.model.relation.ApplicantAttends;
import app.handicraft.model.user.Applicant;
import app.handicraft.repository.ApplicantAttendsRepository;
import app.handicraft.util.AttendanceStatus;

import java.util.List;

public class ApplicantAttendsService {

    private final ApplicantAttendsRepository applicantAttendsRepository;

    public ApplicantAttendsService(ApplicantAttendsRepository applicantAttendsRepository) {
        this.applicantAttendsRepository = applicantAttendsRepository;
    }

    public ApplicantAttends addApplicantToCourse(Applicant applicant, Course course){
        if(applicant == null){
            throw new RuntimeException();
        }
        if(course == null){
            throw new RuntimeException();
        }
        if(applicantAttendsRepository.existsByApplicantAndCourse(applicant,course)){
            throw new RuntimeException();
        }
        var applicantAttends = new ApplicantAttends(course.getCurrentCourseFee(), AttendanceStatus.WILL_ATTEND,applicant,course);
        return applicantAttendsRepository.save(applicantAttends);
    }

    public List<Course> getApplicantCourses(Applicant applicant){
        if(applicant == null){
            throw new RuntimeException();
        }
        return applicantAttendsRepository.findDistinctCourseByApplicant(applicant);
    }

    public List<Course> getPrevAttendApplicantCourses(Applicant applicant){
        if(applicant == null){
            throw new RuntimeException();
        }
        return applicantAttendsRepository.findDistinctCourseByApplicantAndAttendanceStatus(applicant,AttendanceStatus.PREVIOUSLY_ATTENDED);
    }

    public List<Course> getWillAttendApplicantCourses(Applicant applicant){
        if(applicant == null){
            throw new RuntimeException();
        }
        return applicantAttendsRepository.findDistinctCourseByApplicantAndAttendanceStatus(applicant,AttendanceStatus.WILL_ATTEND);
    }

    public List<Course> getAttendingApplicantCourses(Applicant applicant){
        if(applicant == null){
            throw new RuntimeException();
        }
        return applicantAttendsRepository.findDistinctCourseByApplicantAndAttendanceStatus(applicant,AttendanceStatus.ATTENDING);
    }
}
