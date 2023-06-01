package server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.common.*;
import server.repositories.BookingRepository;
import server.repositories.FlightRepository;
import server.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    //private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    //private final NotificationService notificationService;

    @Autowired
    public FlightService(FlightRepository flightRepository, UserRepository userRepository) {
        this.flightRepository = flightRepository;
        //this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        //this.notificationService = notificationService;
    }

    public Optional<FlightModel> getFlight(Long flightId) {
        return flightRepository.findById(flightId);
    }

    public List<FlightModel> getFlights() {
        return flightRepository.findAll();
    }

    public void addNewFlight(FlightModel flight) {
        Optional<FlightModel> flightOptional =  flightRepository.findById(flight.getFlightId());
        if (flightOptional.isPresent()) {
            throw new IllegalStateException("flight already exists");
        }
        flightRepository.save(flight);
    }

    public void deleteFlight(Long flightId) {
        if (!flightRepository.existsById(flightId)) {
            throw new IllegalStateException("flight does not exist");
        }
        flightRepository.deleteById(flightId);
    }

    @Transactional
    public void updateFlight(Long flightId,
                             String fromAirport,
                             String toAirport,
                             LocalDateTime departureTime,
                             LocalDateTime landingTime,
                             String terminal,
                             String airplaneType,
                             String airline,
                             FlightStatusEnum flightStatusEnum) {
        FlightModel flight = flightRepository.findById(flightId)
                .orElseThrow(()->new IllegalStateException("flight does not exist"));

        if (fromAirport != null && fromAirport.length() > 0 && !Objects.equals(flight.getFromAirport(), fromAirport)) {
            flight.setFromAirport(fromAirport);
        }

        if (toAirport != null && toAirport.length() > 0 && !Objects.equals(flight.getToAirport(), toAirport)) {
            flight.setToAirport(toAirport);
        }

        if (departureTime != null && !Objects.equals(flight.getDepartureTime(), departureTime)) {
            flight.setDepartureTime(departureTime);
        }

        if (landingTime != null && !Objects.equals(flight.getLandingTime(), landingTime)) {
            flight.setLandingTime(landingTime);
        }

        if (terminal != null && terminal.length() > 0 && !Objects.equals(flight.getTerminal(), terminal)) {
            flight.setTerminal(terminal);
        }

        if (airplaneType != null && airplaneType.length() > 0 && !Objects.equals(flight.getAirplaneType(), airplaneType)) {
            flight.setAirplaneType(airplaneType);
        }

        if (airline != null && airline.length() > 0 && !Objects.equals(flight.getAirline(), airline)) {
            flight.setAirline(airline);
        }

        if (flightStatusEnum != null && !Objects.equals(flight.getFlightStatus(), flightStatusEnum)) {
            flight.setFlightStatus(flightStatusEnum);
        }
    }

    public Optional<List<FlightReturnModel>> getFlightsByCode(String fromAirport, String toAirport) {
        return Optional.of(flightRepository.findByCode(fromAirport, toAirport).stream().map(n->FlightReturnModel.fromFlightModel(n)).toList());
    }

    /*public void requestService(Long flightId, Long userId) {
        String seat = bookingRepository.getSeatOfUser(userId, flightId);
        List<Long> usersOnFlightIds = bookingRepository.getAllUsersOnFlight(flightId);
        for (Long id : usersOnFlightIds) {
            UserModel user = userRepository.findById(flightId)
                    .orElseThrow(()->new IllegalStateException("user does not exist"));
            if (user.getUserRole() == UserRoleEnum.SERVICE) {
                String message = "User at seat " + seat + " requested service.";
                NotificationModel notification = new NotificationModel(NotificationTypeEnum.FOR_STAFF, flightId, userId, 0, FlightStatusEnum.NORMAL, message);
                notificationService.addNewNotification(notification);
            }
        }
    }*/
}
