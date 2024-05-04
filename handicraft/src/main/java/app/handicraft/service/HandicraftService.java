package app.handicraft.service;

import app.handicraft.dto.createCourse.CreateCourseRequest;
import app.handicraft.dto.updateCourse.UpdateCourseRequest;
import app.handicraft.model.course.Course;
import app.handicraft.model.handicraft.Handicraft;
import app.handicraft.repository.CourseRepository;

public class HandicraftService {

    private final HandicraftRepository handicraftRepository;

    public HandicraftService(HandicraftRepository handicraftRepository) {
        this.HandicraftRepository = handicraftRepository;
    }

    public Handicraft addHandicraft(CreateHandicraftRequest createHandicraftRequestRequest){
        return null;
    }

    public Handicraft updateHandicraft(UpdateHandicraftRequest updateHandicraftRequest){
        return null;
    }

    public void addInstructorToCourse(){}

    public void addHandicraftToCourse(){}
}
