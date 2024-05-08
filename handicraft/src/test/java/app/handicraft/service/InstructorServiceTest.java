package app.handicraft.service;

import app.handicraft.dto.createInstructor.CreateInstructorRequest;
import app.handicraft.dto.updateInstructor.UpdateInstructorRequest;
import app.handicraft.model.handicraft.HandicraftType;
import app.handicraft.model.user.Instructor;
import app.handicraft.repository.InstructorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;
import java.util.*;


import static jakarta.persistence.GenerationType.UUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InstructorServiceTest {

    @Mock
    private InstructorRepository instructorRepository;
    @Mock
    private HandicraftTypeService handicraftTypeService;


    private List<UUID> handicraftTypeIds;
    private UUID uuid1 ;

    @InjectMocks
    private InstructorService instructorService;
/*
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
*/
    /*
    @Test
    public void testAddInstructor_whenCorrect() {
        List<UUID> handicraftTypeIds = Arrays.asList((java.util.UUID.randomUUID()), (java.util.UUID.randomUUID()), (java.util.UUID.randomUUID()));

        HandicraftType handicraftType = new HandicraftType();
        HandicraftType handicraftType1 = new HandicraftType();
        HandicraftType handicraftType2 = new HandicraftType();

        List<HandicraftType> handicraftTypes = Arrays.asList(handicraftType, handicraftType1, handicraftType2);

        CreateInstructorRequest request = new CreateInstructorRequest("username", "surname", "name", "surname", "123456789", "address", 100F, 150F, handicraftTypeIds);
        Instructor instructorToSave = new Instructor("username", "surname", "name", "surname", "123456789", "address", 100F, 150F);

        when(instructorRepository.save(any(Instructor.class))).thenReturn(instructorToSave);
        when(handicraftTypeService.getAllHandicraftTypesByIds(handicraftTypeIds)).thenReturn(handicraftTypes);

        Instructor savedInstructor = instructorService.addInstructor(request);

        assertNotNull(savedInstructor);
        assertEquals("username", savedInstructor.getUserName());
        assertEquals("surname", savedInstructor.getSurname());
        assertEquals("name", savedInstructor.getName());
        assertEquals("123456789", savedInstructor.getPhoneNumber());
        assertEquals("address", savedInstructor.getAddress());
        assertEquals(100F, savedInstructor.getWeekdayFee());
        assertEquals(150F, savedInstructor.getWeekendFee());

        verify(instructorRepository, times(1)).save(any(Instructor.class));
    }*/


    @Test
    public void testAddHandicraftTypeToInstructor_whenCorrect() {
        Instructor instructor = new Instructor("username", "surname", "name", "surname", "123456789", "address", 100F, 150F);
        HandicraftType handicraftType = new HandicraftType("wood paint","painting woods with colors");

        instructor.setHandicraftTypeList(new ArrayList<>());

        when(instructorRepository.save(any(Instructor.class))).thenReturn(instructor);

        Instructor updatedInstructor = instructorService.addHandicraftTypeToInstructor(handicraftType, instructor);

        assertNotNull(updatedInstructor);
        assertTrue(updatedInstructor.getHandicraftTypeList().contains(handicraftType));

        verify(instructorRepository, times(1)).save(any(Instructor.class));
    }

    @Test
    public void testAddHandicraftTypeToInstructor_whenNullInput() {
        // Test when handicraftType is null
        Instructor instructor = new Instructor("username", "surname", "name", "surname", "123456789", "address", 100F, 150F);
        HandicraftType handicraftType = null;

        instructor.setHandicraftTypeList(new ArrayList<>());

        // Expecting RuntimeException when handicraftType is null
        assertThrows(RuntimeException.class, () -> instructorService.addHandicraftTypeToInstructor(handicraftType, instructor));

        // Test when instructor is null
        HandicraftType validHandicraftType = new HandicraftType("wood paint", "painting woods with colors");
        Instructor nullInstructor = null;

        // Expecting RuntimeException when instructor is null
        assertThrows(RuntimeException.class, () -> instructorService.addHandicraftTypeToInstructor(validHandicraftType, nullInstructor));

        // Verify that repository.save() is not called
        verify(instructorRepository, never()).save(any(Instructor.class));
    }

    @Test
    public void testAddHandicraftTypeToInstructor_whenAlreadyExist() {
        // Create an instructor
        Instructor instructor = new Instructor("username", "surname", "name", "surname", "123456789", "address", 100F, 150F);
        // Create a handicraft type
        HandicraftType handicraftType = new HandicraftType("wood paint", "painting woods with colors");

        // Set instructor's handicraft type list
        List<HandicraftType> handicraftTypeList = new ArrayList<>();
        handicraftTypeList.add(handicraftType);
        instructor.setHandicraftTypeList(handicraftTypeList);

        // Expecting RuntimeException when attempting to add an already existing handicraft type
        assertThrows(RuntimeException.class, () -> instructorService.addHandicraftTypeToInstructor(handicraftType, instructor));

        // Verify that repository.save() is not called
        verify(instructorRepository, never()).save(any(Instructor.class));
    }


    @Test
    public void testGetInstructorById_whenExists() {
        // Create a mock instructor and its ID
        UUID instructorId = java.util.UUID.randomUUID();
        Instructor mockInstructor = new Instructor("username", "surname", "name", "surname", "123456789", "address", 100F, 150F);
        mockInstructor.setId(instructorId);

        // Stub the findById method of the repository to return the mock instructor
        when(instructorRepository.findById(instructorId)).thenReturn(Optional.of(mockInstructor));

        // Call the service method
        Instructor retrievedInstructor = instructorService.getInstructorById(instructorId);

        // Verify that the repository's findById method was called once with the correct ID
        verify(instructorRepository, times(1)).findById(instructorId);

        // Check that the returned instructor is not null and has the correct ID
        assertNotNull(retrievedInstructor);
        assertEquals(instructorId, retrievedInstructor.getId());
    }

    @Test
    public void testGetInstructorById_whenNotExists() {
        // Create a non-existent ID
        UUID nonExistentId = java.util.UUID.randomUUID();

        // Stub the findById method of the repository to return an empty Optional
        when(instructorRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        // Call the service method and expect a RuntimeException
        assertThrows(RuntimeException.class, () -> instructorService.getInstructorById(nonExistentId));

        // Verify that the repository's findById method was called once with the correct ID
        verify(instructorRepository, times(1)).findById(nonExistentId);
    }


}

