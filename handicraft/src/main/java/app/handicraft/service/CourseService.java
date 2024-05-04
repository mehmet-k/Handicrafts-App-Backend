package app.handicraft.service;

import app.handicraft.dto.createCourse.CreateCourseRequest;
import app.handicraft.dto.updateCourse.UpdateCourseRequest;
import app.handicraft.model.course.Course;
import app.handicraft.model.user.Applicant;
import app.handicraft.repository.CourseRepository;

public class CourseService {

    private final CourseRepository courseRepository;

    private final ApplicantService applicantService;

    public CourseService(CourseRepository courseRepository, ApplicantService applicantService) {
        this.courseRepository = courseRepository;
        this.applicantService = applicantService;
    }

    public Course addCourse(CreateCourseRequest createCourseRequest){
        return null;
    }

    public Course updateCourse(UpdateCourseRequest updateCourseRequest){
        return null;
    }

    public void addApplicantToCourse(Course course, Applicant applicant){
        applicantService.addCourseToApplicant(applicant,course);
        /*applicant attends*/
        course.getApplicantAttends().
        course.getApplicants().add(applicant);
        courseRepository.save(course);
    }

}
