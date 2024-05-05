package app.handicraft.service;

import app.handicraft.dto.createApplicant.CreateApplicantRequest;
import app.handicraft.dto.createInstructor.CreateInstructorRequest;
import app.handicraft.dto.updateApplicant.UpdateApplicantRequest;
import app.handicraft.dto.updateInstructor.UpdateInstructorRequest;
import app.handicraft.model.handicraft.HandicraftType;
import app.handicraft.model.user.Applicant;
import app.handicraft.model.user.Instructor;
import app.handicraft.repository.InstructorRepository;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public Instructor addInstructor(CreateInstructorRequest createInstructorRequest){
        if(createInstructorRequest==null){
            throw new RuntimeException();
        }
        var instructor = new Instructor(createInstructorRequest.userName(), createInstructorRequest.surname(), createInstructorRequest.name(),createInstructorRequest.surname(),
                createInstructorRequest.phoneNumber(),createInstructorRequest.address(),createInstructorRequest.fee());
        return instructorRepository.save(instructor);
    }

    public Instructor updateInstructer(UpdateInstructorRequest updateInstructorRequest){
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
        return instructorRepository.save(instructor);
    }

    public boolean checkInstructorAvailability(){return true;}




}
