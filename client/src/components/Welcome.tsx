import React from "react";
import {Button, Col, Container, Form, Row} from "react-bootstrap";

class Welcome extends React.Component {
    render() {
        return (
            <>
                <div className="jumbotron">
                    <img src={require("../assets/logo.png")} width="200" height="200" alt="hallo"/>
                    <h1>Welcome Aboard</h1>
                    <p>
                        Aeronautica is a platform that helps improve your travel experiences. Enjoy your flight! And don't forget to check out our onboard movie selection!
                    </p>
                </div>
                <div className="jumbotron2">
                    <Container>
                        <Row>
                            <Col>
                                <Form>
                                    <Form.Group controlId="userId">
                                        <Form.Label>User Id</Form.Label>
                                        <Form.Control type="userId" placeholder="Enter userId" />
                                        <Form.Text className="text-muted">
                                            Your user Id can be found on your boarding ticket.
                                        </Form.Text>
                                        <Button variant="primary" type="submit">
                                            Submit
                                        </Button>
                                    </Form.Group>
                                </Form>
                            </Col>
                        </Row>
                    </Container>
                </div>
            </>
        );
    }
}

export default Welcome;