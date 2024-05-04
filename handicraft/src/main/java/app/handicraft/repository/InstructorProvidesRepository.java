package app.handicraft.repository;

import app.handicraft.model.relation.InstructorProvides;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InstructorProvidesRepository extends JpaRepository<InstructorProvides, UUID> {
}
