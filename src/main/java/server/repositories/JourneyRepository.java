package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.common.*;

@Repository
public interface JourneyRepository extends JpaRepository<JourneyModel, Long> {
}
