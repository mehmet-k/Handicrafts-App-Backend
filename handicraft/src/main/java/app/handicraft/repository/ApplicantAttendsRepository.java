package app.handicraft.repository;

import app.handicraft.model.course.Course;
import app.handicraft.model.relation.ApplicantAttends;
import app.handicraft.model.user.Applicant;
import app.handicraft.util.AttendanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ApplicantAttendsRepository extends JpaRepository<ApplicantAttends, UUID> {
    public List<Course> findDistinctCourseByApplicant(Applicant applicant);

    public List<Course> findDistinctCourseByApplicantAndAttendanceStatus(Applicant applicant, AttendanceStatus attendanceStatus);

    public Boolean existsByApplicantAndCourse(Applicant applicant, Course course);
}
