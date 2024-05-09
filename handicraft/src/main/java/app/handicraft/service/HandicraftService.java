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
import app.handicraft.util.AttendanceStatus;
import app.handicraft.util.Days;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class HandicraftService {

    private final HandicraftRepository handicraftRepository;

    private final HandicraftTypeService handicraftTypeService;

    private final InstructorService instructorService;
    public HandicraftService(HandicraftRepository handicraftRepository, HandicraftTypeService handicraftTypeService, InstructorService instructorService) {
        this.handicraftRepository = handicraftRepository;
        this.handicraftTypeService = handicraftTypeService;
        this.instructorService = instructorService;
    }

    public Handicraft addHandicraft(CreateHandicraftRequest createHandicraftRequest){
        var handicraftType = handicraftTypeService.getHandicraftById(createHandicraftRequest.handicraftTypeId());
        var instructor = instructorService.getInstructorById(createHandicraftRequest.instructorId());

        Float fee;
        Boolean isWeekend;
        if(createHandicraftRequest.day().equalsIgnoreCase("SUNDAY") || createHandicraftRequest.day().equalsIgnoreCase("SATURDAY")){
            fee = instructor.getWeekendFee();
            isWeekend = true;
        }
        else {
            fee = instructor.getWeekdayFee();
            isWeekend = false;
        }

        var handicraft = new Handicraft(fee,handicraftType,createHandicraftRequest.name(),isWeekend,DayOfWeek.valueOf(createHandicraftRequest.day().toUpperCase()));
        handicraft = handicraftRepository.save(handicraft);
        instructorService.addHandicraftToInstructor(handicraft,instructor);
        return handicraft;
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

    public HandicraftView convertHandicraftToView(Handicraft h){
        return new HandicraftView(h.getId(),h.getFee(),
                h.getHandicraftType().getName(),
                h.getInstructor().getName(),h.getDay().name());
    }

    public List<HandicraftView> convertHandicraftListToHandicraftViewList(List<Handicraft> handicrafts){
        if(handicrafts.isEmpty()){
            return null;
        }
        List<HandicraftView> handicraftViewList = new ArrayList<>();
        for(Handicraft h:handicrafts){
            handicraftViewList
                    .add(convertHandicraftToView(h));
        }
        return handicraftViewList;
    }
    public List<HandicraftView> getAllHandicraftViews(){
        return convertHandicraftListToHandicraftViewList(getAllHandicrafts());
    }

    public List<Handicraft> getHandicraftsByIds(List<UUID> ids){
        List<Handicraft> handicrafts = new ArrayList<>();
        for(UUID id:ids){
            handicrafts.add(getHandicraftById(id));
        }
        return handicrafts;
    }

    public List<Handicraft> setHandicraftsCourseByIds(List<UUID> ids,Course course){
        List<Handicraft> handicrafts = new ArrayList<>();
        for(UUID id:ids){
            Handicraft handicraft = getHandicraftById(id);
            handicraft.setCourse(course);
            handicrafts.add(handicraft);
        }
        return handicrafts;
    }

}
