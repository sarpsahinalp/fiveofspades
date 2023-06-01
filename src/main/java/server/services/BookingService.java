package server.services;

import org.springframework.beans.factory.annotation.Autowired;
import server.common.BookingModel;
import server.repositories.BookingRepository;
import server.repositories.FlightRepository;

import java.util.List;

public class BookingService {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
            this.bookingRepository = bookingRepository;
    }

    public void updateJourneyForFlight(Long flightId, Long journeyId) {
        List<BookingModel> bookings = bookingRepository.findByFlightId(flightId);
        for (BookingModel booking : bookings) {
            booking.setJourneyId(journeyId);
        }
    }
}
