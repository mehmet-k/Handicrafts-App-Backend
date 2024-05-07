package app.handicraft.service;

import app.handicraft.dto.createCourse.CreateCourseRequest;
import app.handicraft.dto.createHandicraft.CreateHandicraftRequest;
import app.handicraft.dto.updateCourse.UpdateCourseRequest;
import app.handicraft.model.course.Course;
import app.handicraft.model.handicraft.Handicraft;
import app.handicraft.model.handicraft.HandicraftType;
import app.handicraft.model.user.Instructor;
import app.handicraft.repository.CourseRepository;
import app.handicraft.repository.HandicraftRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.UUID;


@Service
public class HandicraftService {

    private final HandicraftRepository handicraftRepository;

    public HandicraftService(HandicraftRepository handicraftRepository) {
        this.handicraftRepository = handicraftRepository;
    }

    public Handicraft addHandicraft(CreateHandicraftRequest createHandicraftRequest){
        return null;
    }
/*
    public Handicraft updateHandicraft(UpdateHandicraftRequest updateHandicraftRequest){
        return null;
    }
*/
    public Handicraft getHandicraftById(UUID id){
        return handicraftRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}
