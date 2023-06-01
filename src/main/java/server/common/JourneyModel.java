package server.common;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class JourneyModel {
    @Id
    @SequenceGenerator(
            name = "journey_sequence",
            sequenceName = "journey_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "journey_sequence"
    )
    private Long journeyId;
    private String name;
    @ElementCollection
    private List<Long> flightIds;

    public JourneyModel() {
    }

    public JourneyModel(Long journeyId, String name, List<Long> flightIds) {
        this.journeyId = journeyId;
        this.name = name;
        this.flightIds = flightIds;
    }

    public JourneyModel(String name, List<Long> flightIds) {
        this.name = name;
        this.flightIds = flightIds;
    }

    public Long getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(Long journeyId) {
        this.journeyId = journeyId;
    }

    public List<Long> getFlightIds() {
        return flightIds;
    }

    public void setFlightIds(List<Long> flightIds) {
        this.flightIds = flightIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFlight(Long flightId) {
        this.flightIds.add(flightId);
    }

    public void removeFlight(Long flightId) {
        this.flightIds.remove(flightId);
    }
}
