import { Col, Row, Container} from "react-bootstrap";
import FlightModel from "../../common/FlightModel";
import {  FaTimes } from 'react-icons/fa';


type Props = {
    flightModel: FlightModel,
    seat?: string
}
  
function FlightInfoCanceledDescritpion({ flightModel, seat }: Props) {
    return (
        <Container className={"p-0"}>   
                <Row style = {{borderBottom: "1px solid lightgray", backgroundColor: "lightgray"}} className={"m-0"}>
                    <Col style = {{paddingTop: "1.75rem", paddingBottom: "1.75rem", backgroundColor: "red"}}>
                        <span style={{color: "white", fontSize: "1rem"}}>FLIGHT HAS BEEN CANCELED <FaTimes /></span>
                    </Col>
                </Row>                
            </Container>
    );
}
  
export default FlightInfoCanceledDescritpion;
  