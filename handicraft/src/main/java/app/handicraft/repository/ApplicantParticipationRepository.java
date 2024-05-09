package app.handicraft.repository;

import app.handicraft.model.course.Course;
import app.handicraft.model.relation.ApplicantParticipation;
import app.handicraft.model.user.Applicant;
import app.handicraft.util.AttendanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ApplicantParticipationRepository extends JpaRepository<ApplicantParticipation, UUID> {
    public List<UUID> findDistinctCourseIdsByApplicantId(UUID applicantId);

    public List<UUID> findDistinctCourseIdsByApplicantIdAndAttendanceStatus(UUID applicantId, AttendanceStatus attendanceStatus);

    public Boolean existsByApplicantIdAndCourseId(UUID applicantId, UUID courseId);
}
