import FlightModel from "./common/FlightModel";
import FlightStatusEnum from "./common/util/FlightStatusEnum";

export const normalFlight : FlightModel = 
{
    flightId: 0,
    fromAirport: "MUC",
    toAirport: "SOF",
    departureTime: "13:37",
    landingTime: "14:37",
    date: "29.07.2022",
    landingDate: "29.07.2022",
    terminal: "T02",
    //gate: "B18",
    airplaneType: "Boeing 737 Max",
    airline: "WizzAir",
    flightStatus: FlightStatusEnum.NORMAL
}

export const normalFlight2 : FlightModel = 
{
    flightId: 1,
    fromAirport: "AGB",
    toAirport: "TXL",
    departureTime: "13:37",
    landingTime: "14:37",
    date: "02.08.2022",
    landingDate: "02.08.2022",
    terminal: "T1",
    //gate: "B23",
    airplaneType: "Airbus a320",
    airline: "RyanAir",
    flightStatus: FlightStatusEnum.NORMAL
}

export const normalFlight3 : FlightModel = 
{
    flightId: 2,
    fromAirport: "SOF",
    toAirport: "MUC",
    departureTime: "13:37",
    landingTime: "14:37",
    date: "01.08.2022",
    landingDate: "01.08.2022",
    terminal: "T2",
    //gate: "B08",
    airplaneType: "Boeing 737",
    airline: "RyanAir",
    flightStatus: FlightStatusEnum.NORMAL
}

export const delayedFlight : FlightModel = 
{
    flightId: 3,
    fromAirport: "MUC",
    toAirport: "SOF",
    departureTime: "13:37",
    landingTime: "14:37",
    date: "29.07.2022",
    landingDate: "29.07.2022",
    terminal: "T02",
    //gate: "B18",
    airplaneType: "Boeing 737 Max",
    airline: "WizzAir",
    flightStatus: FlightStatusEnum.DELAYED
}

export const cancelledFlight : FlightModel = 
{
    flightId: 3,
    fromAirport: "MUC",
    toAirport: "SOF",
    departureTime: "13:37",
    landingTime: "14:37",
    date: "30.07.2022",
    landingDate: "30.07.2022",
    terminal: "T02",
    //gate: "B18",
    airplaneType: "Boeing 737 Max",
    airline: "WizzAir",
    flightStatus: FlightStatusEnum.CANCELED
}

export const orderArr : FlightModel[] = [normalFlight,normalFlight2,normalFlight3,delayedFlight,cancelledFlight];
