package app.handicraft.repository;

import app.handicraft.model.course.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseTypeRepository extends JpaRepository<CourseType, UUID> {
}
