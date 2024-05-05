package app.handicraft.service;

import app.handicraft.model.course.Course;
import app.handicraft.model.relation.ApplicantAttends;
import app.handicraft.model.user.Applicant;
import app.handicraft.repository.ApplicantAttendsRepository;
import app.handicraft.util.AttendanceStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ApplicantAttendsService {
    private final ApplicantAttendsRepository applicantAttendsRepository;
    private final CourseService courseService;

    public ApplicantAttendsService(ApplicantAttendsRepository applicantAttendsRepository, CourseService courseService) {
        this.applicantAttendsRepository = applicantAttendsRepository;
        this.courseService = courseService;
    }

    public ApplicantAttends addApplicantToCourse(Applicant applicant, Course course){
        if(applicant == null){
            throw new RuntimeException("Applicant is null");
        }
        if(course == null){
            throw new RuntimeException("Course is null");
        }
        if(applicantAttendsRepository.existsByApplicantAndCourse(applicant,course)){
            throw new RuntimeException("This applicant is already attending to the course");
        }
        if(Objects.equals(course.getAttendantCount(), course.getMaxAttendants())){
            throw new RuntimeException("Course has max attendance!");
        }
        course.setAttendantCount(course.getAttendantCount()+1);
        courseService.updateCourse(course);
        var applicantAttends = new ApplicantAttends(course.getCurrentCourseFee(), AttendanceStatus.WILL_ATTEND,applicant,course);
        return applicantAttendsRepository.save(applicantAttends);
    }

    public List<Course> getApplicantCourses(Applicant applicant){
        if(applicant == null){
            throw new RuntimeException("Applicant is null");
        }
        return applicantAttendsRepository.findDistinctCourseByApplicant(applicant);
    }

    public List<Course> getPrevAttendApplicantCourses(Applicant applicant){
        if(applicant == null){
            throw new RuntimeException("Applicant is null");
        }
        return applicantAttendsRepository.findDistinctCourseByApplicantAndAttendanceStatus(applicant,AttendanceStatus.PREVIOUSLY_ATTENDED);
    }

    public List<Course> getWillAttendApplicantCourses(Applicant applicant){
        if(applicant == null){
            throw new RuntimeException("Applicant is null");
        }
        return applicantAttendsRepository.findDistinctCourseByApplicantAndAttendanceStatus(applicant,AttendanceStatus.WILL_ATTEND);
    }

    public List<Course> getAttendingApplicantCourses(Applicant applicant){
        if(applicant == null){
            throw new RuntimeException("Applicant is null");
        }
        return applicantAttendsRepository.findDistinctCourseByApplicantAndAttendanceStatus(applicant,AttendanceStatus.ATTENDING);
    }
}
