package app.handicraft.service;

import app.handicraft.repository.InstructorRepository;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    publiaddHandicraftTypeToInstructor(){}

    public boolean checkInstructorAvailability(){return true;}
}
