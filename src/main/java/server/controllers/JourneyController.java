package server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.common.BookingModel;
import server.common.FlightModel;
import server.common.JourneyModel;
import server.services.BookingService;
import server.services.JourneyService;

import java.util.List;

@RestController
@RequestMapping(path="api/journey")
public class JourneyController {
    private final JourneyService journeyService;
    //private final BookingService bookingService;

    @Autowired
    public JourneyController(JourneyService journeyService) {
        this.journeyService = journeyService;
        //this.bookingService = bookingService;
    }

    @GetMapping(path = "{journeyId}")
    public ResponseEntity<JourneyModel> getJourney(@PathVariable("journeyId") Long journeyId) {
        return ResponseEntity.of(journeyService.getJourney(journeyId));
    }

    @GetMapping(path = "getFlightsOfJourney/{journeyId}")
    public ResponseEntity<List<FlightModel>> getFlightsOfJourney(@PathVariable("journeyId") Long journeyId) {
        return ResponseEntity.of(journeyService.getFlightsOfJourney(journeyId));
    }

    // postman: POST, http://localhost:8080/api/journey, {}
    @PostMapping()
    public ResponseEntity<Void> createJourney(@RequestBody JourneyModel journeyModel) {
        journeyService.addNewJourney(journeyModel);
        return ResponseEntity.ok().build();
    }

    // postman: PUT, http://localhost:8080/api/journey/addFlight/1?flightId=1
    @PutMapping(path = "addFlight/{journeyId}")
    public ResponseEntity<Void> addFlightToJourney(@PathVariable("journeyId") Long journeyId, @RequestParam Long flightId) {
        journeyService.addFlightToJourney(journeyId, flightId);
        //bookingService.updateJourneyForFlight(flightId, journeyId);
        return ResponseEntity.ok().build();
    }


    @PutMapping(path = "removeflight/{journeyId}")
    public ResponseEntity<Void> removeFlightFromJourney(@PathVariable("journeyId") Long journeyId, @RequestBody Long flightId) {
        journeyService.removeFlightFromJourney(journeyId, flightId);
        //bookingService.updateJourneyForFlight(flightId, -1L);
        return ResponseEntity.ok().build();
    }

    // PUT, http://localhost:8080/api/journey/1?flightIds=1,2,3,4
    @PutMapping(path = "{journeyId}")
    public ResponseEntity<Void> updateJourney(@PathVariable("journeyId") Long journeyId,
                                           @RequestParam(required = false) List<Long> flightIds) {
        journeyService.updateJourney(journeyId, flightIds);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "{journeyId}")
    public ResponseEntity<Void> deleteJourney(@PathVariable("journeyId") Long journeyId) {
        journeyService.deleteJourney(journeyId);
        return ResponseEntity.ok().build();
    }

}
