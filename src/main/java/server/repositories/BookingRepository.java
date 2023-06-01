package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.common.BookingModel;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingModel, Long> {
    @Query("SELECT u FROM BookingModel u WHERE u.flightId=?1")
    List<BookingModel> findByFlightId(Long flightId);

/*    @Query("SELECT u.seat FROM BookingModel u WHERE u.userId=?1 AND u.flightId=?2")
    String getSeatOfUser(Long userId, Long flightId);

    @Query("SELECT u.userId FROM BookingModel u WHERE u.flightId=?1")
    List<Long> getAllUsersOnFlight(Long flightId);*/
}
