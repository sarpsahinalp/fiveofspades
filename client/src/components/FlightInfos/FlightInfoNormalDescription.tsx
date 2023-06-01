import { Col, Row, Container} from "react-bootstrap";
import FlightModel from "../../common/FlightModel";
import { FaMapMarkedAlt, FaExclamationTriangle, FaPlane } from 'react-icons/fa';


type Props = {
    flightModel: FlightModel,
    seat?: string
}
  
function FlightInfoNormalDescritpion({ flightModel, seat }: Props) {
    return (
        <Container className={"p-0"}>
                <Row style = {{borderBottom: "1px solid lightgray", paddingBottom:"0.4rem", paddingTop:"0.4rem"}} className={"m-0"}>
                    <Col style = {{borderRight: "1px solid lightgray"}}>
                        DEPARTURE
                    </Col>
                    <Col>
                        ARRIVAL
                    </Col>
                </Row>
                <Row style = {{borderBottom: "1px solid lightgray", paddingBottom:"0.4rem", paddingTop:"0.4rem"}} className={"m-0"}>
                    <Col style = {{paddingLeft: "6%"}}>
                        <div style={{display:"flex", flexFlow:"column", alignItems:"center"}}>
                            <div style={{display:"flex", flexFlow:"column", alignItems:"start"}}>
                                <span style = {{fontSize: "0.8rem"}}>DATE</span>
                                <span >{flightModel.date}</span>
                            </div>
                        </div>
                    </Col>
                    <Col>
                        <div style={{display:"flex", flexFlow:"column", alignItems:"center"}}>
                            <div style={{display:"flex", flexFlow:"column", alignItems:"start"}}>
                                <span style = {{fontSize: "0.8rem"}}>SCHEDULED</span>
                                <span >{flightModel.departureTime}</span>
                            </div>
                        </div>
                    </Col>
                    <Col style = {{borderRight: "1px solid lightgray", paddingRight: "6%"}}>
                        <div style={{display:"flex", flexFlow:"column", alignItems:"center"}}>
                            <div style={{display:"flex", flexFlow:"column", alignItems:"start"}}>
                                <span style = {{fontSize: "0.8rem"}}>ACTUAL</span>
                                <span >{flightModel.departureTime}</span>
                            </div>
                        </div>
                    </Col>
                    
                    <Col style = {{paddingLeft: "6%"}}>
                        <div style={{display:"flex", flexFlow:"column", alignItems:"center"}}>
                            <div style={{display:"flex", flexFlow:"column", alignItems:"start"}}>
                                <span style = {{fontSize: "0.8rem"}}>DATE</span>
                                <span >{flightModel.landingDate}</span>
                            </div>
                        </div>
                    </Col>
                    <Col>
                        <div style={{display:"flex", flexFlow:"column", alignItems:"center"}}>
                            <div style={{display:"flex", flexFlow:"column", alignItems:"start"}}>
                                <span style = {{fontSize: "0.8rem"}}>SCHEDULED</span>
                                <span >{flightModel.landingTime}</span>
                            </div>
                        </div>
                    </Col>
                    <Col style = {{paddingRight: "6%"}}>
                        <div style={{display:"flex", flexFlow:"column", alignItems:"center"}}>
                            <div style={{display:"flex", flexFlow:"column", alignItems:"start"}}>
                                <span style = {{fontSize: "0.8rem"}}>ACTUAL</span>
                                <span >{flightModel.landingTime}</span>
                            </div>
                        </div>
                    </Col>
                </Row>                
                <Row style = {{borderBottom: "1px solid lightgray", backgroundColor: "lightgray"}} className={"m-0"}>
                    <Col style = {{paddingTop: "0.75rem", paddingBottom: "0.75rem"}}>
                        <span>ACTUAL TIMES MAY VARY <FaExclamationTriangle /></span>
                    </Col>
                </Row>
                <Row style = {{borderBottom: "1px solid lightgray", paddingBottom:"0.4rem", paddingTop:"0.4rem"}} className={"m-0"}>
                    <Col style = {{borderRight: "1px solid lightgray"}}>
                        <div style={{display:"flex", flexFlow:"column", alignItems:"center"}}>
                            <div style={{display:"flex", flexFlow:"column", alignItems:"start"}}>
                                <span style = {{fontSize: "0.8rem"}}>AIRLINE</span>
                                <span>{flightModel.airline}</span>
                            </div>
                        </div>
                    </Col>                                
                    <Col>
                        <div style={{display:"flex", flexFlow:"column", alignItems:"center"}}>
                            <div style={{display:"flex", flexFlow:"column", alignItems:"start"}}>
                                <span style = {{fontSize: "0.8rem"}}>PLANE TYPE</span>
                                <span >{flightModel.airplaneType}</span>
                            </div>
                        </div>
                    </Col>
                </Row>
                <Row style = {{borderBottom: "1px solid lightgray", paddingBottom:"0.4rem", paddingTop:"0.4rem"}} className={"m-0"}>                    
                    <Col style = {{borderRight: "1px solid lightgray"}}>
                        <div style={{display:"flex", flexFlow:"column", alignItems:"center"}}>
                            <div style={{display:"flex", flexFlow:"column", alignItems:"start"}}>
                                <span style = {{fontSize: "0.8rem"}}>TERMINAL</span>
                                <span>{flightModel.terminal}</span>
                            </div>
                        </div>
                    </Col>
                    {seat !== undefined? 
                        <Col style = {{borderRight: "1px solid lightgray"}}>
                            <div style={{display:"flex", flexFlow:"column", alignItems:"center"}}>
                                <div style={{display:"flex", flexFlow:"column", alignItems:"start"}}>
                                    <span style = {{fontSize: "0.8rem"}}>SEAT</span>
                                    <span >{seat}</span>
                                </div>
                            </div>
                        </Col>:null}     
                    <Col>
                        <div style={{display:"flex", flexFlow:"column", alignItems:"center"}}>
                            <div style={{display:"flex", flexFlow:"column", alignItems:"start"}}>
                                <span style = {{fontSize: "0.8rem"}}>GATE</span>
                                <span >{/*flightModel.gate*/"B13"}</span>
                            </div>
                        </div>
                    </Col>
                </Row>
                <Row style = {{paddingBottom:"1rem", paddingTop:"1rem", fontSize:"1.25rem", backgroundColor: "#0EC259"}} className={"m-0"}>
                    <Col>
                        <span style={{color: "white"}}>SEE ON MAP <FaMapMarkedAlt /></span>
                    </Col>
                </Row>
                
            </Container>
    );
}
  
export default FlightInfoNormalDescritpion;
  