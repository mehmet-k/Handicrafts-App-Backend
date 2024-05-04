package app.handicraft.repository;

import app.handicraft.model.user.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, UUID> {

    public Applicant findApplicantByUserName(String userName);
}
