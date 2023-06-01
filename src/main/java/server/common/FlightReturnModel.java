package server.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class FlightReturnModel {

    public Long flightId;
    //Number?
    public String fromAirport;
    public String toAirport;
    public String departureTime;
    public String date;
    public String landingTime;
    public String terminal;
    public String airplaneType;
    public String airline;
    public int flightStatus;

    public String landingDate;

    private FlightReturnModel() {
    }

    private static String getTime(LocalDateTime t) {
        String hour = Integer.toString(t.getHour());
        hour = hour.length() == 1 ? "0" + hour : hour;
        String minute = Integer.toString(t.getMinute());
        minute = minute.length() == 1 ? "0" + minute : minute;
        return hour + ":" + minute;
    }

    private static String getDate(LocalDateTime t) {
        return t.getDayOfMonth() + "." + t.getMonthValue() + "." + t.getYear();
    }

    public static Optional<FlightReturnModel> fromFlightModel(Optional<FlightModel> opt){
        if(opt.isEmpty()){
            return Optional.empty();
        }
        else{
            return Optional.of(FlightReturnModel.fromFlightModel(opt.get()));
        }
    }

    public static FlightReturnModel fromFlightModel(FlightModel model) {
        var fm = new FlightReturnModel() {{
            flightId = model.getFlightId();
            fromAirport = model.getFromAirport();
            toAirport = model.getToAirport();
            departureTime = getTime(model.getDepartureTime());
            landingTime = getTime(model.getLandingTime());
            date = getDate(model.getDepartureTime());
            landingDate = getDate(model.getLandingTime());
            terminal = model.getTerminal();
            airplaneType = model.getAirplaneType();
            airline = model.getAirline();
            flightStatus = model.getFlightStatus().ordinal();
        }};
        return fm;
    }
}
