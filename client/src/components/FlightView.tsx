import React, { Component } from "react";

import { Card, Table} from "react-bootstrap";
import { Link , useParams} from "react-router-dom";
import FlightModel from "../common/FlightModel";
import FlightStatusEnum from "../common/util/FlightStatusEnum";
import {getAllFlights, getFlight} from "../controllers/FlightController";
import {timeFormat, dateFormat} from "../dateTimeGetter"
import FlightInfo from "./FlightInfos/FlightInfo";

export default function FlightView(){

    let {flightId} = useParams<any>();
    
    const [isLoading,setIsLoading] = React.useState(true);
    const [flightModel,setFlightModel] = React.useState<FlightModel | undefined>();

    React.useEffect(()=>{
        if(flightId !== undefined){

            getFlight(parseInt(flightId)).then(flight => {
                setFlightModel(flight);
                //TODO
                //fetch and set seat
                setIsLoading(false);
            });

        }
    },[]);

    return (
        <div style={{marginTop:"5%"}}>
            {isLoading || flightModel === undefined? <span>Loading</span>:<FlightInfo flightModel={flightModel} /*seat={seat}*/></FlightInfo>}
        </div>
    );
  
}