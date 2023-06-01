import React, { Component } from "react";
import {Button, Card, Form} from "react-bootstrap";
import {Link} from 'react-router-dom';


export default class Login extends Component {
 
  state = {
    login: "",
};

render() {



  return (
  <Card className={"border border-dark"}>
    <Card.Header>
        <h1>Log In</h1>
    </Card.Header>
    <Card.Body style={{"textAlign":"left"}}>
        <Form id="feedbackId">
            <Form.Group className="mb-3">
                <Form.Label>E-mail address</Form.Label>
                <Form.Control required
                    type="text"
                    name={'e-mail address'}
                    placeholder="Enter e-mail address" />
            </Form.Group>

            <Form.Group className="mb-3">
                <Form.Label>Password</Form.Label>
                <Form.Control required
                    type="feedback"
                    name="feedback"
                    value={this.state.login}
                    onChange={(e) => this.setState({login: e.target.value})}
                    placeholder="Enter password" />
            </Form.Group>
          
            <Button 
                size="sm"
                variant="outline-success"
                type="submit">
                Log In
            </Button>

        </Form>
    </Card.Body>
    </Card>
);
}
}