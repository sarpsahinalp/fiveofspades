package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import server.common.*;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<FlightModel, Long> {

    @Query("SELECT u FROM FlightModel u WHERE u.fromAirport=?1 AND u.toAirport=?2")
    List<FlightModel> findByCode(String fromAirport, String toAirport);
}
