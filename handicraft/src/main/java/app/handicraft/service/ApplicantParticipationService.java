package app.handicraft.service;

import app.handicraft.model.course.Course;
import app.handicraft.model.course.CourseView;
import app.handicraft.model.user.Applicant;
import app.handicraft.repository.ApplicantParticipationRepository;
import app.handicraft.util.AttendanceStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApplicantParticipationService {

    private final ApplicantParticipationRepository applicantParticipationRepository;
    private final ApplicantService applicantService;
    private final CourseService courseService;

    public ApplicantParticipationService(ApplicantParticipationRepository applicantParticipationRepository, ApplicantService applicantService, CourseService courseService) {
        this.applicantParticipationRepository = applicantParticipationRepository;
        this.applicantService = applicantService;
        this.courseService = courseService;
    }

    public List<CourseView> getApplicantCourseViews(Applicant applicant){
        return courseService.convertCourseListToCourseViewList(getApplicantCourses(applicant));
    }

    public List<Course> getApplicantCourses(Applicant applicant){
        if(applicant == null){
            throw new RuntimeException("Applicant is null");
        }
        return courseService.getCoursesByIds(getApplicantCourseIds(applicant));
    }

    public List<UUID> getApplicantCourseIds(Applicant applicant){
        if(applicant == null){
            throw new RuntimeException("Applicant is null");
        }
        return applicantParticipationRepository.findDistinctCourseIdsByApplicant(applicant);
    }

    public List<UUID> getPrevAttendApplicantCourseIds(Applicant applicant){
        if(applicant == null){
            throw new RuntimeException("Applicant is null");
        }
        return applicantParticipationRepository.findDistinctCourseIdsByApplicantAndAttendanceStatus(applicant, AttendanceStatus.PREVIOUSLY_ATTENDED);
    }

    public List<UUID> getAttendingApplicantCourseIds(Applicant applicant){
        if(applicant == null){
            throw new RuntimeException("Applicant is null");
        }
        return applicantParticipationRepository.findDistinctCourseIdsByApplicantAndAttendanceStatus(applicant,AttendanceStatus.ATTENDING);
    }

    public List<UUID> getWillAttendApplicantCourseIds(Applicant applicant){
        if(applicant == null){
            throw new RuntimeException("Applicant is null");
        }
        return applicantParticipationRepository.findDistinctCourseIdsByApplicantAndAttendanceStatus(applicant,AttendanceStatus.WILL_ATTEND);
    }

}
