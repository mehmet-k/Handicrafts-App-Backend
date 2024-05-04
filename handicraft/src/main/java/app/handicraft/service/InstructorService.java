package app.handicraft.service;

import app.handicraft.repository.InstructorRepository;

public class InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


}
