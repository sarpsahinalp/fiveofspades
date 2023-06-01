import React, { Component } from "react";
import {Button, Card, Form} from "react-bootstrap";
// import { useNavigate } from "react-router-dom";

export default class Register extends Component {

    state = {
        signup: "",
    };

  render() {
  //   let navigate = useNavigate(); 
  // const routeChange = () =>{ 
  //   let path = `newPath`; 
  //   navigate(path);
  // }
      return (
      <Card className={"border border-dark"}>
        <Card.Header>
            <h1>Sign Up</h1>
        </Card.Header>
        <Card.Body style={{"textAlign":"left"}}>
            <Form id="registerId">
                <Form.Group className="mb-3">
                    <Form.Label>Name</Form.Label>
                    <Form.Control required
                        type="text"
                        name={'email'}
                        placeholder="Enter name" />
                </Form.Group>

                <Form.Group className="mb-3">
                    <Form.Label>E-Mail</Form.Label>
                    <Form.Control required
                        type="text"
                        name={'email'}
                        placeholder="Enter e-mail address" />
                </Form.Group>

                <Form.Group className="mb-3">
                    <Form.Label>Birthdate (yyyy-mm-dd)</Form.Label>
                    <Form.Control required
                        type="text"
                        name={'email'}
                        placeholder="yyyy-mm-dd" />
                </Form.Group>

                <Form.Group className="mb-3">
                    <Form.Label>Password</Form.Label>
                    <Form.Control required
                        type="feedback"
                        name="feedback"
                        value={this.state.signup}
                        onChange={(e) => this.setState({signup: e.target.value})}
                        placeholder="Enter password" />
                </Form.Group>
                <Button
                    size="sm"
                    variant="outline-success"
                    type="submit">
                    Sign Up
                </Button> 
            </Form>
        </Card.Body>
        </Card>
    );
  }
}