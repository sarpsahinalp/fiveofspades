import React from "react";

import { Card, Table} from "react-bootstrap";
import { Link } from "react-router-dom";
import FlightModel from "../common/FlightModel";
import FlightStatusEnum from "../common/util/FlightStatusEnum";
import {getAllFlights} from "../controllers/FlightController";
import {timeFormat, dateFormat} from "../dateTimeGetter"


function getStatusString (flightStatus:FlightStatusEnum){
    switch(flightStatus){
        case FlightStatusEnum.NORMAL:
            return "Normal";
        case FlightStatusEnum.DELAYED:
            return "Delayed";
        case FlightStatusEnum.CANCELED:
            return "Canceled";
    }
}

export default function FlightList(){
    
    const [flights,setFlights] = React.useState<FlightModel[]>([]);

    React.useEffect(()=>{
        getAllFlights().then(flights => {
            setFlights(flights);
        });
    },[]);

    return (
      <Card>
        <Card.Header>
            <h3>Flight List</h3>
        </Card.Header>
        <Card.Body>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Connection</th>
                        <th>Airline</th>
                        <th>Date</th>
                        <th>Departure Time</th>
                        <th>Arrival Time</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                {flights.length === 0 ? (
                    <tr>
                        <td colSpan={3}>No flights found</td>
                    </tr>) :
                    flights.map(flight => (
                        <tr key={flight.flightId}>
                            <td>{flight.fromAirport + " ⇒ " + flight.toAirport}</td>
                            <td>{flight.airline}</td>
                            <td>{flight.date}</td>
                            <td>{flight.departureTime}</td>
                            <td>{flight.landingTime + (flight.date==flight.landingDate?"":` (${flight.landingDate})`)}</td>
                            <td>{getStatusString(flight.flightStatus)}</td>
                            <td>
                                <Link to={`${flight.flightId}`}>
                                    <button type="button" className={"btn btn-primary"+(flight.flightStatus == FlightStatusEnum.CANCELED?" disabled": "")}>
                                        {flight.flightStatus !== FlightStatusEnum.CANCELED? "View" : "Canceled"}
                                    </button>
                                </Link>                                
                            </td>
                        </tr>
                    ))}
                </tbody>
            </Table>
        </Card.Body>
        </Card>
    );
  
}