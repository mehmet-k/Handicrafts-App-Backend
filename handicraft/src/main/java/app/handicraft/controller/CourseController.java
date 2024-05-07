package app.handicraft.controller;

import app.handicraft.dto.createCourse.CreateCourseRequest;
import app.handicraft.dto.createCourse.CreateCourseResponse;
import app.handicraft.dto.updateCourse.UpdateCourseRequest;
import app.handicraft.dto.updateCourse.UpdateCourseResponse;
import app.handicraft.model.course.Course;
import app.handicraft.model.course.CourseView;
import app.handicraft.service.ApplicantService;
import app.handicraft.service.CourseService;
import app.handicraft.service.HandicraftService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final ApplicantService applicantService;

    private final HandicraftService handicraftService;

    public CourseController(CourseService courseService, ApplicantService applicantService, HandicraftService handicraftService) {
        this.courseService = courseService;
        this.applicantService = applicantService;
        this.handicraftService = handicraftService;
    }

    @PostMapping
    public ResponseEntity<CreateCourseResponse> createCourse(@RequestBody CreateCourseRequest createCourseRequest){
        var course = courseService.addCourse(createCourseRequest);
        return new ResponseEntity<>(new CreateCourseResponse(course.getId()), HttpStatus.CREATED);
    }

    @PutMapping("/get/{id}")
    public ResponseEntity<UpdateCourseResponse> updateCourse(@RequestBody UpdateCourseRequest updateCourseRequest, @PathVariable UUID courseId){
        return null;
        //return new ResponseEntity<>(new CreateCourseResponse(),HttpStatus.OK);
    }

    @GetMapping("/update/{id}")
    public Course getCourseById(@PathVariable UUID id){
        return null;
    }

    @PutMapping("/addHandicraft/{id}")
    public Course addHandicraftToCourse(UUID courseId, UUID handicraftId){
        var course = getCourseById(courseId);
        var handicraft = handicraftService.getHandicraftById(handicraftId);
        courseService.addHandicraftToCourse(course,handicraft);
        return course;
    }

    @PutMapping("/addApplicant/{id}")
    public Course addApplicantToCourse(UUID courseId,UUID applicantId){
        var course = getCourseById(courseId);
        var applicant = applicantService.getApplicantById(applicantId);
        courseService.addApplicantToCourse(applicant,course);
        return course;
    }

    @GetMapping("/all")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/allViews")
    public List<CourseView> getAllCourseViews(){
        return courseService.getAllCourseView();
    }
}
