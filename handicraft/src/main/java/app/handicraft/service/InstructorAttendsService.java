package app.handicraft.service;

import app.handicraft.model.course.Course;
import app.handicraft.model.handicraft.Handicraft;
import app.handicraft.model.relation.InstructorAttends;
import app.handicraft.model.user.Applicant;
import app.handicraft.model.user.Instructor;
import app.handicraft.repository.InstructorAttendsRepository;
import app.handicraft.util.AttendanceStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorAttendsService {

    private final InstructorAttendsRepository instructorAttendsRepository;

    public InstructorAttendsService(InstructorAttendsRepository instructorAttendsRepository) {
        this.instructorAttendsRepository = instructorAttendsRepository;
    }

    public InstructorAttends addInstructorToHandicraft(Instructor instructor, Handicraft handicraft){
        if(instructor == null){
            throw new RuntimeException("Instructor is null");
        }
        if(handicraft == null){
            throw new RuntimeException("Handicraft is null");
        }
        if(instructorAttendsRepository.existsByInstructorAndHandicraft(instructor,handicraft)){
            throw new RuntimeException("Instructor already attends to this handicraft");
        }
        var instructorAttends = new InstructorAttends(instructor.getFee(), AttendanceStatus.ATTENDING,instructor,handicraft);
        return instructorAttendsRepository.save(instructorAttends);
    }

    public List<Handicraft> getAllInstructorHandicrafts(Instructor instructor){
        if(instructor == null){
            throw new RuntimeException("Instructor is null");
        }
        return instructorAttendsRepository.findDistinctHandicraftByInstructor(instructor);
    }

    public List<Handicraft> getPrevAttendInstructorHandicrafts(Instructor instructor){
        if(instructor == null){
            throw new RuntimeException("Instructor is null");
        }
        return instructorAttendsRepository.findDistinctHandicraftByInstructorAndAttendanceStatus(instructor,AttendanceStatus.PREVIOUSLY_ATTENDED);
    }

    public List<Handicraft> getAttendingInstructorHandicrafts(Instructor instructor){
        if(instructor == null){
            throw new RuntimeException("Instructor is null");
        }
        return instructorAttendsRepository.findDistinctHandicraftByInstructorAndAttendanceStatus(instructor,AttendanceStatus.ATTENDING);
    }

    public List<Handicraft> getWillAttendInstructorHandicrafts(Instructor instructor){
        if(instructor == null){
            throw new RuntimeException("Instructor is null");
        }
        return instructorAttendsRepository.findDistinctHandicraftByInstructorAndAttendanceStatus(instructor,AttendanceStatus.WILL_ATTEND);
    }

}
