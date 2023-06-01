package server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.common.FlightModel;
import server.common.JourneyModel;
import server.repositories.FlightRepository;
import server.repositories.JourneyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JourneyService {
    private final JourneyRepository journeyRepository;
    private final FlightRepository flightRepository;

    @Autowired
    public JourneyService(JourneyRepository journeyRepository, FlightRepository flightRepository) {
        this.journeyRepository = journeyRepository;
        this.flightRepository = flightRepository;
    }

    public Optional<JourneyModel> getJourney(Long journeyId) {
        return journeyRepository.findById(journeyId);
    }

    public List<JourneyModel> getJourneys() {
        return journeyRepository.findAll();
    }

    public Optional<List<FlightModel>> getFlightsOfJourney(Long journeyId) {
            JourneyModel currentJourney = journeyRepository.findById(journeyId)
                    .orElseThrow(() -> new IllegalStateException("journey does not exist"));

            List<Long> flightsIds = currentJourney.getFlightIds();
            List<FlightModel> flightList = new ArrayList<>();

            for (Long flightId : flightsIds) {
                flightList.add(flightRepository.getById(flightId));
            }

            return Optional.of(flightList);
    }

    public void addNewJourney(JourneyModel journey) {
        journeyRepository.save(journey);
    }

    @Transactional
    public void updateJourney(Long journeyId, List<Long> flightIds) {
        JourneyModel journey = journeyRepository.findById(journeyId)
                .orElseThrow(() -> new IllegalStateException("journey does not exist"));
        if (flightIds != null) {
            journey.setFlightIds(flightIds);
        }
    }


    public void deleteJourney(Long journeyId) {
        if (!journeyRepository.existsById(journeyId)) {
            throw new IllegalStateException("journey does not exist");
        }
        journeyRepository.deleteById(journeyId);
    }

    @Transactional
    public void addFlightToJourney(Long journeyId, Long flightId) {
        JourneyModel journey = journeyRepository.findById(journeyId)
                .orElseThrow(() -> new IllegalStateException("journey does not exist"));
        journey.addFlight(flightId);
    }

    @Transactional
    public void removeFlightFromJourney(Long journeyId, Long flightId) {
        JourneyModel journey = journeyRepository.findById(journeyId)
                .orElseThrow(() -> new IllegalStateException("journey does not exist"));
        journey.removeFlight(flightId);
    }
}
