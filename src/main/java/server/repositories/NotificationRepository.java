package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.common.NotificationModel;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationModel, Long> {
}
