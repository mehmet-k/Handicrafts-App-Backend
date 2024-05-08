package app.handicraft.service;

import app.handicraft.dto.createApplicant.CreateApplicantRequest;
import app.handicraft.dto.createInstructor.CreateInstructorRequest;
import app.handicraft.dto.updateApplicant.UpdateApplicantRequest;
import app.handicraft.dto.updateInstructor.UpdateInstructorRequest;
import app.handicraft.model.handicraft.Handicraft;
import app.handicraft.model.handicraft.HandicraftType;
import app.handicraft.model.user.*;
import app.handicraft.repository.InstructorRepository;
import app.handicraft.util.Days;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    private final HandicraftTypeService handicraftTypeService;

    public InstructorService(InstructorRepository instructorRepository, HandicraftTypeService handicraftTypeService) {
        this.instructorRepository = instructorRepository;
        this.handicraftTypeService = handicraftTypeService;
    }

    public Instructor addInstructor(CreateInstructorRequest createInstructorRequest){
        if(createInstructorRequest==null){
            throw new RuntimeException();
        }
        var instructor = new Instructor(createInstructorRequest.userName(), createInstructorRequest.surname(), createInstructorRequest.name(),createInstructorRequest.surname(),
                createInstructorRequest.phoneNumber(),createInstructorRequest.address(),createInstructorRequest.weekdayFee(),createInstructorRequest.weekendFee());
        if(createInstructorRequest.handicraftTypeIds()!=null){
            //instructor.setHandicraftTypeList(handicraftTypeService.getAllHandicraftTypesByIds(createInstructorRequest.handicraftTypeIds()));
            for(UUID id: createInstructorRequest.handicraftTypeIds()){
                HandicraftType handicraftType = handicraftTypeService.getHandicraftById(id);
                instructor.getHandicraftTypeList().add(handicraftType);
                handicraftType.getInstructors().add(instructor);
            }
        }
        return instructorRepository.save(instructor);
    }

    public Instructor updateInstructor(UpdateInstructorRequest updateInstructorRequest){
        if(updateInstructorRequest==null){
            throw new RuntimeException();
        }
        var instructor = instructorRepository.findById(updateInstructorRequest.id()).orElseThrow(()->new RuntimeException("Applicant with this id does not exist"));
        instructor.setUserName(updateInstructorRequest.userName());
        instructor.setName(updateInstructorRequest.name());
        instructor.setSurname(updateInstructorRequest.surname());
        instructor.setPhoneNumber(updateInstructorRequest.phoneNumber());
        instructor.setAddress(updateInstructorRequest.address());
        instructor.seteMail(updateInstructorRequest.eMail());
        instructor.setWeekdayFee(updateInstructorRequest.weekdayFee());
        instructor.setWeekendFee(updateInstructorRequest.weekendFee());

        return instructorRepository.save(instructor);
    }

    public Instructor addHandicraftTypeToInstructor(HandicraftType handicraftType, Instructor instructor){
        if(instructor==null){
            throw new RuntimeException("instructor is null");
        }
        if(handicraftType==null){
            throw new RuntimeException("handicraftType is null");
        }
        if(instructor.getHandicraftTypeList().contains(handicraftType)){
            throw new RuntimeException("handicraftType already exists");
        }
        instructor.getHandicraftTypeList().add(handicraftType);
        handicraftType.getInstructors().add(instructor);
        return instructorRepository.save(instructor);
    }

    public Instructor addHandicraftToInstructor(Handicraft handicraft, Instructor instructor){
        if(instructor == null){
            throw new RuntimeException("instructor is null");
        }
        if(handicraft == null){
            throw new RuntimeException("handicraft is null");
        }
        if(handicraft.getInstructor() != null){
            throw new RuntimeException("This handicraft already has an instructor!");
        }
        for(DayOfWeek d:handicraft.getDays()){
            if(instructor.getDays().contains(d)){
                throw new RuntimeException("Instructor is busy on:" +d.name());
            }
            else{
                instructor.getDays().add(d);
            }
        }
        instructor.getHandicrafts().add(handicraft);
        handicraft.setInstructor(instructor);
        return instructorRepository.save(instructor);
    }

    public List<DayOfWeek> getAvailableInstructorDays(Instructor instructor){
        List<DayOfWeek> availableDays = new ArrayList<>();
        for(DayOfWeek d:DayOfWeek.values()){
            if(!instructor.getDays().contains(d)){
                availableDays.add(d);
            }
        }
        return availableDays;
    }

    public boolean checkInstructorAvailability(){return true;}

    public List<Instructor> getAllInstructors(){
        return instructorRepository.findAll();
    }

    public List<InstructorView> convertInstructorListToInstructorViewList(List<Instructor> instructors){
        List<InstructorView> instructorViews = new ArrayList<>();
        for(Instructor i:instructors){
            instructorViews.add(convertInstructorToView(i));
        }
        return instructorViews;
    }

    public InstructorView convertInstructorToView(Instructor i){
        return new InstructorView(i.getId(),i.getUserName(),i.getName(),
                i.getSurname(),i.geteMail(),i.getPhoneNumber(),i.getAddress(),i.getWeekdayFee(),i.getWeekendFee(),
                Days.convertDaysEnumListToStringList(i.getDays()));
    }

    public List<UserView> getAllInstructorViews(){
        return null;
    }

    public Instructor getInstructorById(UUID id){
        return instructorRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
