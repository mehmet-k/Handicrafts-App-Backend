package app.handicraft.repository;

import app.handicraft.model.handicraft.Handicraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HandicraftRepository extends JpaRepository<Handicraft, UUID> {
}
