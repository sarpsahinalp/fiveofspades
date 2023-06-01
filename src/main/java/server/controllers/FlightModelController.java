package server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.common.*;
import server.services.FlightService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/flight")
@CrossOrigin(origins = "http://localhost:3000")

public class FlightModelController {
    private final FlightService flightService;

    @Autowired
    public FlightModelController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping(path = "{flightId}")
    public ResponseEntity<Optional<FlightReturnModel>> getFlightModel(@PathVariable("flightId") Long flightId) {
        return ResponseEntity.ok(FlightReturnModel.fromFlightModel(flightService.getFlight(flightId)));
    }

    @PostMapping()
    public ResponseEntity<Void> createFlightModel(@RequestBody FlightModel flightModel) {
        flightService.addNewFlight(flightModel);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "{flightId}")
    public ResponseEntity<Void> updateFlight(
            @PathVariable("flightId") Long flightId,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to,
            @RequestParam(required = false) LocalDateTime departureTime,
            @RequestParam(required = false) LocalDateTime landingTime,
            @RequestParam(required = false) String terminal,
            @RequestParam(required = false) String airplaneType,
            @RequestParam(required = false) String airline,
            @RequestParam(required = false) FlightStatusEnum flightStatusEnum) {
        flightService.updateFlight(flightId, from, to, departureTime, landingTime, terminal, airplaneType, airline, flightStatusEnum);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "{flightId}")
    public ResponseEntity<Void> deleteFlightModel(@PathVariable("flightId") Long flightId) {
        flightService.deleteFlight(flightId);
        return ResponseEntity.ok().build();
    }

    // GET,
    @GetMapping(path = "/searchByAirport")
    public ResponseEntity<List<FlightReturnModel>> searchFlight(@RequestParam String fromAirport, @RequestParam String toAirport) {
        return ResponseEntity.of(flightService.getFlightsByCode(fromAirport, toAirport));
    }

    @PostMapping(path = "requestService/{flightId}")
    public ResponseEntity<Void> requestService(@PathVariable("flightId") Long flightId, @RequestParam Long userId) {
        //flightService.requestService(flightId, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<FlightReturnModel>> getFlightModels() {
        return ResponseEntity.ok(flightService.getFlights().stream().map(n->FlightReturnModel.fromFlightModel(n)).toList());
    }

}
