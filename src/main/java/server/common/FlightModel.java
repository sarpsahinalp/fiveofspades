package server.common;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class FlightModel {
    @Id
    @SequenceGenerator(
            name = "flight_sequence",
            sequenceName = "flight_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "flight_sequence"
    )

    private Long flightId;
    //Number?
    private String fromAirport;
    private String toAirport;
    private LocalDateTime departureTime;
    private LocalDateTime landingTime;
    private String terminal;
    private String airplaneType;
    private String airline;
    private FlightStatusEnum flightStatus;

    public FlightModel () {

    }

    public FlightModel(Long flightId, String fromAirport, String toAirport, LocalDateTime departureTime, LocalDateTime landingTime, String terminal, String airplaneType, String airline, FlightStatusEnum flightStatus) {
        this.flightId = flightId;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.departureTime = departureTime;
        this.landingTime = landingTime;
        this.terminal = terminal;
        this.airplaneType = airplaneType;
        this.airline = airline;
        this.flightStatus = flightStatus;
    }

    public FlightModel(String fromAirport, String toAirport, LocalDateTime departureTime, LocalDateTime landingTime, String terminal, String airplaneType, String airline, FlightStatusEnum flightStatus) {
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.departureTime = departureTime;
        this.landingTime = landingTime;
        this.terminal = terminal;
        this.airplaneType = airplaneType;
        this.airline = airline;
        this.flightStatus = flightStatus;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getLandingTime() {
        return landingTime;
    }

    public void setLandingTime(LocalDateTime landingTime) {
        this.landingTime = landingTime;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public FlightStatusEnum getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatusEnum flightStatus) {
        this.flightStatus = flightStatus;
    }


    @Override
    public String toString(){
        return "Flight{" +
                "id=" + flightId +
                ", from='" + fromAirport + '\'' +
                ", to='" + toAirport + '\'' +
                ", departure time=" + departureTime +
                ", landing time=" + landingTime +
                ", terminal='" + terminal + '\'' +
                ", airplane type='" + airplaneType + '\'' +
                ", airline='" + airline + '\'' +
                ", flight status=" + flightStatus +
                '}';
    }
}