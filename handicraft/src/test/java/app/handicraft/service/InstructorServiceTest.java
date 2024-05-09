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
    private UUID uuid1;

    @InjectMocks
    private InstructorService instructorService;

    /*
        @BeforeEach
        public void setUp() {
            MockitoAnnotations.openMocks(this);
        }
    */
    @Test
    public void testAddInstructor_whenCorrect() {
        handicraftTypeIds = new ArrayList<>();

        handicraftTypeIds.add(java.util.UUID.randomUUID());
        handicraftTypeIds.add(java.util.UUID.randomUUID());
        handicraftTypeIds.add(java.util.UUID.randomUUID());

        HandicraftType handicraftType = new HandicraftType();
        HandicraftType handicraftType1 = new HandicraftType();
        HandicraftType handicraftType2 = new HandicraftType();

        List<HandicraftType> handicraftTypes = new ArrayList<>();
        handicraftTypes.add(handicraftType);
        handicraftTypes.add(handicraftType1);
        handicraftTypes.add(handicraftType2);

        CreateInstructorRequest request = new CreateInstructorRequest("username", "surname", "name", "surname", "123456789", "address", 100F, 150F, handicraftTypeIds);
        Instructor instructor = new Instructor("username", "surname", "name", "surname", "123456789", "address", 100F, 150F);

        when(instructorRepository.save(any(Instructor.class))).thenReturn(instructor);
        when(handicraftTypeService.getAllHandicraftTypesByIds(handicraftTypeIds)).thenReturn(handicraftTypes);
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

}