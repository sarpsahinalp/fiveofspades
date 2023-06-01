import React, { Component } from "react";
import { Link } from "react-router-dom";

import { Navbar, Container, Col, Button } from "react-bootstrap";
export default class ServicesAvailable extends Component {
  render() {
      //display all available inflight services with buttons to request them
        return (
            <div>
                <Navbar>
                    <Container>
                        <Col>
                            <h1>Services Available</h1>
                        </Col>
                    </Container>
                </Navbar>
                <Container>
                    <Col>
                        <h2>Request Staff</h2>
                        <p>
                            If you need help or information, press the button below.
                        </p>
                        <button onClick={() => {alert('A flight attendant will come to you shortly!');}}>Request Staff</button>
                        <h2>Request Snack Cart</h2>
                        <p>
                            Press the button below and the snack cart with a fine selection of snacks and drinks will be brought to your row shortly.
                        </p>
                        <button onClick={() => {alert('Choo choo! The snack cart is on its way.');}}>Request Snack Cart</button> 
                    </Col>
                </Container>
            </div>
        );
  }
}