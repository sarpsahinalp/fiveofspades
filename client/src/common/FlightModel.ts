import FlightStatusEnum from "./util/FlightStatusEnum"

export default interface FlightModel {
    flightId: number,
    fromAirport: string,
    toAirport: string,
    departureTime: string,
    landingTime: string,
    terminal: string,
    date: string,
    landingDate:string,
    //gate: string,
    airplaneType: string,
    airline: string,
    flightStatus: FlightStatusEnum
}

//14:00 14:30 (Delayed)