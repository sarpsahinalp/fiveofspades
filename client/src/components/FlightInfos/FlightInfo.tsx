import React, { Component } from "react";

import { Card, Table, Col, Row, Container} from "react-bootstrap";
import { propTypes } from "react-bootstrap/esm/Image";
import FlightModel from "../../common/FlightModel";
import { FaMapMarkedAlt, FaExclamationTriangle, FaPlane } from 'react-icons/fa';
import FlightStatusEnum from "../../common/util/FlightStatusEnum";
import FlightInfoNormalDescritpion from "./FlightInfoNormalDescription";
import FlightInfoDelayedDescritpion from "./FlightInfoDelayedDescription";
import FlightInfoCanceledDescritpion from "./FlightInfoCanceledInfo";


type Props = {
    flightModel: FlightModel,
    seat?: string
}

function getDescription(flightModel:FlightModel, seat?:string){
    switch(flightModel.flightStatus){
        case FlightStatusEnum.NORMAL:
            return <FlightInfoNormalDescritpion flightModel={flightModel} seat={seat} />;
        case FlightStatusEnum.DELAYED:
            return <FlightInfoDelayedDescritpion flightModel={flightModel} seat={seat}/>;
        case FlightStatusEnum.CANCELED:
            return <FlightInfoCanceledDescritpion flightModel={flightModel} seat={seat}/>;
        default: 
            return <FlightInfoNormalDescritpion flightModel={flightModel} seat={seat} />;
    }
}
  
function FlightInfo({ flightModel, seat }: Props) {
    return (
        <Card style={{marginRight: "10%", marginLeft: "10%"}}>
        <Card.Header className="p-0" style={{backgroundColor: "lightgray"}}>
            <Container>
                <Row style = {{fontSize: "2rem", paddingBottom:"0.4rem", paddingTop:"0.4rem"}}>
                    <Col>
                        <span>{flightModel.fromAirport}</span>
                    </Col>
                    <Col style = {{maxWidth:"5%"}}>
                        <FaPlane />
                    </Col>
                    <Col>
                        <span>{flightModel.toAirport}</span>
                    </Col>
                </Row>
            </Container>
        </Card.Header>
        <Card.Body className={"p-0"}>
            {getDescription(flightModel,seat)}
        </Card.Body>
      </Card>
    );
}
  
export default FlightInfo;
  