package app.handicraft.service;

import app.handicraft.dto.createApplicant.CreateApplicantRequest;
import app.handicraft.dto.updateApplicant.UpdateApplicantRequest;
import app.handicraft.model.course.Course;
import app.handicraft.model.relation.ApplicantParticipation;
import app.handicraft.model.user.Applicant;
import app.handicraft.repository.ApplicantRepository;
import app.handicraft.repository.ApplicantParticipationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ApplicantServiceTest {

    @Mock
    private ApplicantRepository applicantRepository;

    @Mock
    private ApplicantParticipationRepository applicantParticipationRepository;

    @InjectMocks
    private ApplicantService applicantService;
/*
    @Test
    public void testAddApplicant_whenCorrect() {
        // Create a mock request
        CreateApplicantRequest request = new CreateApplicantRequest("username", "surname", "name", "surname", "123456789", "address");

        // Mock the repository save method
        when(applicantRepository.save(any(Applicant.class))).thenReturn(new Applicant());

        // Call the service method
        Applicant savedApplicant = applicantService.addApplicant(request);

        // Verify that repository.save() is called once
        verify(applicantRepository, times(1)).save(any(Applicant.class));

        // Check that the saved applicant is not null
        assertNotNull(savedApplicant);
    }*/
/*
    @Test
    public void testUpdateApplicant_whenCorrect() {
        // Create a mock request
        UpdateApplicantRequest request = new UpdateApplicantRequest("username", "surname", "name", "surname", "123456789", "address", "email");

        // Mock the repository findById method
        UUID applicantId = UUID.randomUUID();
        Applicant mockApplicant = new Applicant();
        when(applicantRepository.findById(applicantId)).thenReturn(java.util.Optional.of(mockApplicant));

        // Mock the repository save method
        when(applicantRepository.save(any(Applicant.class))).thenReturn(new Applicant());

        // Call the service method
        Applicant updatedApplicant = applicantService.updateApplicant(request, applicantId);

        // Verify that repository.findById() is called once with the correct ID
        verify(applicantRepository, times(1)).findById(applicantId);

        // Verify that repository.save() is called once
        verify(applicantRepository, times(1)).save(any(Applicant.class));

        // Check that the updated applicant is not null
        assertNotNull(updatedApplicant);
    }
*/
    @Test
    public void testGetApplicantById_whenExists() {
        // Create a mock applicant and its ID
        UUID applicantId = UUID.randomUUID();
        Applicant mockApplicant = new Applicant();
        mockApplicant.setId(applicantId);

        // Stub the findById method of the repository to return the mock applicant
        when(applicantRepository.findById(applicantId)).thenReturn(java.util.Optional.of(mockApplicant));

        // Call the service method
        Applicant retrievedApplicant = applicantService.getApplicantById(applicantId);

        // Verify that the repository's findById method was called once with the correct ID
        verify(applicantRepository, times(1)).findById(applicantId);

        // Check that the returned applicant is not null and has the correct ID
        assertNotNull(retrievedApplicant);
        assertEquals(applicantId, retrievedApplicant.getId());
    }

    @Test
    public void testGetApplicantById_whenNotExists() {
        // Create a non-existent ID
        UUID nonExistentId = UUID.randomUUID();

        // Stub the findById method of the repository to return an empty Optional
        when(applicantRepository.findById(nonExistentId)).thenReturn(java.util.Optional.empty());

        // Call the service method and expect a RuntimeException
        assertThrows(RuntimeException.class, () -> applicantService.getApplicantById(nonExistentId));

        // Verify that the repository's findById method was called once with the correct ID
        verify(applicantRepository, times(1)).findById(nonExistentId);
    }

/*
    @Test
    public void testAddCourseToApplicant_whenCorrect() {
        // Create a mock applicant and course
        Applicant applicant = new Applicant();
        Course course = new Course();
        course.setDays(List.of(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY)); // Assume the course is on Monday and Wednesday

        // Stub the repository methods
        when(applicantRepository.save(any(Applicant.class))).thenReturn(applicant);
        when(applicantParticipationRepository.existsByApplicantAndCourse(applicant, course)).thenReturn(false);

        // Call the service method
        ApplicantParticipation participation = applicantService.addCourseToApplicant(applicant, course);

        // Verify that the repository methods are called appropriately
        verify(applicantRepository, times(1)).save(any(Applicant.class));
        verify(applicantParticipationRepository, times(1)).save(any(ApplicantParticipation.class));

        // Verify that the participation is not null
        assertNotNull(participation);
        assertEquals(course.getCurrentCourseFee(), participation.getCourseFee());
        assertEquals(ApplicantParticipation.AttendanceStatus.WILL_ATTEND, participation.getAttendanceStatus());
    }*/

    @Test
    public void testAddCourseToApplicant_whenAlreadyAttending() {
        // Create a mock applicant and course
        Applicant applicant = new Applicant();
        Course course = new Course();
        course.setDays(List.of(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY)); // Assume the course is on Monday and Wednesday

        // Stub the repository methods to simulate the applicant is already attending the course
        when(applicantParticipationRepository.existsByApplicantAndCourse(applicant, course)).thenReturn(true);

        // Call the service method and expect a RuntimeException
        assertThrows(RuntimeException.class, () -> applicantService.addCourseToApplicant(applicant, course));

        // Verify that the repository methods are not called
        verify(applicantRepository, never()).save(any(Applicant.class));
        verify(applicantParticipationRepository, never()).save(any(ApplicantParticipation.class));
    }
}
