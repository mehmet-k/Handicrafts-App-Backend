package app.handicraft.repository;

import app.handicraft.model.handicraft.HandicraftType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HandicraftTypeRepository extends JpaRepository<HandicraftType, UUID> {
}
