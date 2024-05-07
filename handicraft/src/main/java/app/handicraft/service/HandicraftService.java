package app.handicraft.service;

import app.handicraft.dto.createCourse.CreateCourseRequest;
import app.handicraft.dto.createHandicraft.CreateHandicraftRequest;
import app.handicraft.dto.updateCourse.UpdateCourseRequest;
import app.handicraft.model.course.Course;
import app.handicraft.model.course.CourseView;
import app.handicraft.model.handicraft.Handicraft;
import app.handicraft.model.handicraft.HandicraftType;
import app.handicraft.model.handicraft.HandicraftView;
import app.handicraft.model.user.Instructor;
import app.handicraft.repository.CourseRepository;
import app.handicraft.repository.HandicraftRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
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

    public List<Handicraft> getAllHandicrafts(){
        return handicraftRepository.findAll();
    }

    public List<HandicraftView> convertHandicraftListToHandicraftViewList(List<Handicraft> handicrafts){
        List<HandicraftView> handicraftViewList = new ArrayList<>();
        for(Handicraft h:handicrafts){
            handicraftViewList
                    .add(new HandicraftView(h.getId(),h.getFee(),h.getHandicraftType(),h.getInstructor(),h.getCourse(),h.getDays()));
        }
        return handicraftViewList;
    }
    public List<HandicraftView> getAllHandicraftViews(){
        return convertHandicraftListToHandicraftViewList(getAllHandicrafts());
    }

}
