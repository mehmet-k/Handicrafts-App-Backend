package app.handicraft.repository;

import app.handicraft.model.handicraft.Handicraft;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HandicraftRepository extends JpaRepository<Handicraft, UUID> {
}
