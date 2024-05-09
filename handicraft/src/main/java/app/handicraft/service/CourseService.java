package app.handicraft.service;

import app.handicraft.dto.createCourse.CreateCourseRequest;
import app.handicraft.dto.updateCourse.UpdateCourseRequest;
import app.handicraft.model.course.Course;
import app.handicraft.model.course.CourseView;
import app.handicraft.model.handicraft.Handicraft;
import app.handicraft.model.relation.ApplicantParticipation;
import app.handicraft.model.user.Applicant;
import app.handicraft.repository.CourseRepository;
import app.handicraft.util.AttendanceStatus;
import app.handicraft.util.Days;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final ApplicantService applicantService;
    private final HandicraftService handicraftService;

    public CourseService(CourseRepository courseRepository, ApplicantService applicantService, HandicraftService handicraftService) {
        this.courseRepository = courseRepository;
        this.applicantService = applicantService;
        this.handicraftService = handicraftService;
    }

    public Course addCourse(CreateCourseRequest createCourseRequest){
        var course = new Course(createCourseRequest.name(),createCourseRequest.fee(),createCourseRequest.capacity());
        Float fee = calculateCourseFee(course);
        course.setDays(getCourseDaysFromHandicraftList(course.getHandicrafts()));
        course.setCurrentCourseFee(fee);
        course.setBaseCourseFee(fee);
        courseRepository.save(course);
        course.setHandicrafts(handicraftService.setHandicraftsCourseByIds(createCourseRequest.handicraftIdList(),course));
        return courseRepository.save(course);
    }

    public List<DayOfWeek> getCourseDaysFromHandicraftList(List<Handicraft> handicrafts){
        List<DayOfWeek> days = new ArrayList<>();
        for(Handicraft h:handicrafts){
            days.add(h.getDay());
        }
        return days;
    }

    public Float calculateCourseFee(Course course){
        Float fee = 0.0F;
        for(Handicraft h: course.getHandicrafts()){
            fee+=h.getFee();
        }
        return fee;
    }

    public Course getCourseById(UUID id){
        return courseRepository.findById(id).orElseThrow(RuntimeException::new);
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

    public Course addHandicraftToCourse(Course course, Handicraft handicraft){
        if(course == null){
            throw new RuntimeException("Course is null");
        }
        if(handicraft == null){
            throw new RuntimeException("Handicraft is null");
        }
        course.getHandicrafts().add(handicraft);
        handicraft.setCourse(course);
        if(course.getDays().contains(handicraft.getDay())){
            throw new RuntimeException("Course program for "+handicraft.getDay().name()+" is not avaliable");
        }
        else{
            course.getDays().add(handicraft.getDay());
        }
        return courseRepository.save(course);
    }

    public Course addApplicantToCourse(Applicant applicant, Course course){
        if(applicant == null){
            throw new RuntimeException("Applicant is null");
        }
        if(course == null){
            throw new RuntimeException("Course is null");
        }
        if(Objects.equals(course.getAttendantCount(), course.getMaxAttendants())){
            throw new RuntimeException("Course has max attendance!");
        }
        var applicantAttends = applicantService.addCourseToApplicant(applicant,course);
        course.setAttendantCount(course.getAttendantCount()+1);
        course.getApplicantAttendsList().add(applicantAttends);
        applicantAttends.setCourse(course);
        return courseRepository.save(course);
    }

    public Course markCourseAsFinished(Course course){
        if(course == null){
            throw new RuntimeException("Course is null");
        }
        if(!course.getActive()){
            throw new RuntimeException("The course is already closed!");
        }
        if(!course.getApplicantAttendsList().isEmpty()){
            for(ApplicantParticipation a: course.getApplicantAttendsList()){
                a.setAttendanceStatus(AttendanceStatus.PREVIOUSLY_ATTENDED);
            }
        }
        course.setActive(false);
        course.setCloseInstant(Instant.now());
        return courseRepository.save(course);
    }

    public Course markCourseAsStarted(Course course){
        if(course == null){
            throw new RuntimeException("Course is null");
        }
        if(!course.getActive()){
            throw new RuntimeException("This course is closed!");
        }
        if(!course.getApplicantAttendsList().isEmpty()){
            for(ApplicantParticipation a: course.getApplicantAttendsList()){
                a.setAttendanceStatus(AttendanceStatus.ATTENDING);
                applicantService.clearSpecifiedDaysFromCalendar(a.getApplicant(),course.getDays());
            }
        }
        else{
            throw new RuntimeException("Can't start course wih 0 applicants");
        }
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public List<CourseView> getAllCourseViews(){
        List<Course> courses = courseRepository.findAll();
        return convertCourseListToCourseViewList(courses);
    }

    public List<CourseView> convertCourseListToCourseViewList(List<Course> courses){
        if(courses.isEmpty()){
            return null;
        }
        List<CourseView> courseViews = new ArrayList<>();
        for(Course c:courses){
            courseViews
                    .add(new CourseView(c.getId(),c.getName(),c.getCurrentCourseFee(),c.getMaxAttendants(),
                            c.getAttendantCount(),handicraftService.convertHandicraftListToHandicraftViewList(c.getHandicrafts())
                            , Days.convertDaysEnumListToStringList(c.getDays())));
        }
        return courseViews;
    }

    public List<Course> getCoursesByIds(List<UUID> idList){
        List<Course> courses = new ArrayList<>();
        for(UUID id:idList){
            courses.add(courseRepository.findById(id).orElseThrow(RuntimeException::new));
        }
        return courses;
    }



}
