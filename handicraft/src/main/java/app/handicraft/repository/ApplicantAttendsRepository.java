package app.handicraft.repository;

import app.handicraft.model.relation.ApplicantAttends;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplicantAttendsRepository extends JpaRepository<ApplicantAttends, UUID> {
}
