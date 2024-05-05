package app.handicraft.service;

import app.handicraft.dto.createCourse.CreateCourseRequest;
import app.handicraft.dto.updateCourse.UpdateCourseRequest;
import app.handicraft.model.course.Course;
import app.handicraft.model.user.Applicant;
import app.handicraft.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public Course updateCourse(Course course){
        if(course == null){
            throw new RuntimeException();
        }
        return courseRepository.save(course);
    }

    public void addApplicantToCourse(){}

    public void addCourseToApplicant(){}

    public void addHandicraftToCourse(){}


}
