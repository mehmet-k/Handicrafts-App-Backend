package app.handicraft.repository;

import app.handicraft.model.handicraft.HandicraftType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HandicraftTypeRepository extends JpaRepository<HandicraftType, UUID> {
}
