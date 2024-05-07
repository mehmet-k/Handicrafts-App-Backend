package app.handicraft.service;

import app.handicraft.dto.createInstructor.CreateInstructorRequest;
import app.handicraft.dto.updateInstructor.UpdateInstructorRequest;
import app.handicraft.model.handicraft.HandicraftType;
import app.handicraft.model.user.Instructor;
import app.handicraft.repository.InstructorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;
import java.util.*;


import static jakarta.persistence.GenerationType.UUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InstructorServiceTest {

    @Mock
    private InstructorRepository instructorRepository;

    @InjectMocks
    private InstructorService instructorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        UUID uuid = UUID.randomUUID();

    }

    @Test
    public void testAddInstructor() {
        CreateInstructorRequest request = new CreateInstructorRequest("username", "surname", "name", "surname", "123456789", "address", 100F, 150F);
        Instructor instructor = new Instructor("username", "surname", "name", "surname", "123456789", "address", 100F, 150F);

        when(instructorRepository.save(any(Instructor.class))).thenReturn(instructor);

        Instructor savedInstructor = instructorService.addInstructor(request);

        assertNotNull(savedInstructor);
        assertEquals("username", savedInstructor.getUserName());
        assertEquals("surname", savedInstructor.getSurname());
        assertEquals("name", savedInstructor.getName());
        assertEquals("123456789", savedInstructor.getPhoneNumber());
        assertEquals("address", savedInstructor.getAddress());
        assertEquals(100, savedInstructor.getWeekdayFee());
        assertEquals(150, savedInstructor.getWeekendFee());

        verify(instructorRepository, times(1)).save(any(Instructor.class));
    }

    @Test
    public void testUpdateInstructor() {
        UpdateInstructorRequest request = new UpdateInstructorRequest(1L, "newUsername", "newName", "newSurname", "987654321", "newAddress", "newemail@example.com", 200F, 250F);
        Instructor existingInstructor = new Instructor("username", "surname", "name", "surname", "123456789", "address", 100F, 150F);

        when(instructorRepository.findById(UUID.randomUUID())).thenReturn(Optional.of(existingInstructor));
        when(instructorRepository.save(any(Instructor.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Instructor updatedInstructor = instructorService.updateInstructer(request);

        assertNotNull(updatedInstructor);
        assertEquals("newUsername", updatedInstructor.getUserName());
        assertEquals("newName", updatedInstructor.getName());
        assertEquals("newSurname", updatedInstructor.getSurname());
        assertEquals("987654321", updatedInstructor.getPhoneNumber());
        assertEquals("newAddress", updatedInstructor.getAddress());
        assertEquals("newemail@example.com", updatedInstructor.geteMail());
        assertEquals(200, updatedInstructor.getWeekdayFee());
        assertEquals(250, updatedInstructor.getWeekendFee());

        verify(instructorRepository, times(1)).findById(1L);
        verify(instructorRepository, times(1)).save(any(Instructor.class));
    }

    @Test
    public void testAddHandicraftTypeToInstructor() {
        Instructor instructor = new Instructor("username", "surname", "name", "surname", "123456789", "address", 100F, 150F);
        HandicraftType handicraftType = new HandicraftType("wood paint","painting woods with colors");

        instructor.setHandicraftTypeList(new ArrayList<>());

        when(instructorRepository.save(any(Instructor.class))).thenReturn(instructor);

        Instructor updatedInstructor = instructorService.addHandicraftTypeToInstructor(handicraftType, instructor);

        assertNotNull(updatedInstructor);
        assertTrue(updatedInstructor.getHandicraftTypeList().contains(handicraftType));

        verify(instructorRepository, times(1)).save(any(Instructor.class));
    }
}

