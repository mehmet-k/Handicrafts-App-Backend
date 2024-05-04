package app.handicraft.service;

import app.handicraft.dto.createCourseType.CreateCourseTypeRequest;
import app.handicraft.dto.updateCourse.UpdateCourseRequest;
import app.handicraft.dto.updateCourseType.UpdateCourseTypeRequest;
import app.handicraft.model.course.CourseType;
import app.handicraft.repository.CourseTypeRepository;

public class CourseTypeService {

    private final CourseTypeRepository courseTypeRepository;

    public CourseTypeService(CourseTypeRepository courseTypeRepository) {
        this.courseTypeRepository = courseTypeRepository;
    }

    public CourseType addCourseType(CreateCourseTypeRequest createCourseTypeRequest){
        return null;
    }

    public CourseType updateCourseType(UpdateCourseTypeRequest updateCourseTypeRequest){
        return null;
    }
    
}
