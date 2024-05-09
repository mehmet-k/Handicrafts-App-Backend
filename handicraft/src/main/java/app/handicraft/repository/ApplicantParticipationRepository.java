package app.handicraft.repository;

import app.handicraft.model.course.Course;
import app.handicraft.model.relation.ApplicantParticipation;
import app.handicraft.model.user.Applicant;
import app.handicraft.util.AttendanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ApplicantParticipationRepository extends JpaRepository<ApplicantParticipation, UUID> {
    @Query("SELECT DISTINCT ap.course.id FROM ApplicantParticipation ap " +
            "WHERE ap.applicant.id = :applicantId")
    public List<UUID> findDistinctCourseIdsByApplicantId(@Param("applicantId") UUID applicantId);

    @Query("SELECT DISTINCT ap.course.id FROM ApplicantParticipation ap " +
            "WHERE ap.applicant.id = :applicantId AND ap.attendanceStatus = :attendanceStatus")
    public List<UUID> findDistinctCourseIdsByApplicantIdAndAttendanceStatus(@Param("applicantId") UUID applicantId, @Param("attendanceStatus") AttendanceStatus attendanceStatus);

    public Boolean existsByApplicantIdAndCourseId(UUID applicantId, UUID courseId);
}
