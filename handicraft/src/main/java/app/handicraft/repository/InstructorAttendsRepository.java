package app.handicraft.repository;

import app.handicraft.model.course.Course;
import app.handicraft.model.handicraft.Handicraft;
import app.handicraft.model.relation.InstructorAttends;
import app.handicraft.model.user.Instructor;
import app.handicraft.util.AttendanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InstructorAttendsRepository extends JpaRepository<InstructorAttends, UUID> {
    public List<Handicraft> findDistinctHandicraftByInstructor(Instructor instructor);

    public List<Handicraft> findDistinctHandicraftByInstructorAndAttendanceStatus(Instructor instructor, AttendanceStatus attendanceStatus);

    public Boolean existsByInstructorAndHandicraft(Instructor instructor, Handicraft handicraft);
}
