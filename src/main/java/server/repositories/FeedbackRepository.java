package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.common.FeedbackModel;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackModel, Long> {
}
