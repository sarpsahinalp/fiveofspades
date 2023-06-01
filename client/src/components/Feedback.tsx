import React, { Component, useState } from "react";
import {Button, Card, Form} from "react-bootstrap";

const StarRating = () => {
    const [rating, setRating] = useState(0);
    return (
      <div className="star-rating">
        {[...Array(5)].map((star, index) => {
          index += 1;
          return (
            <button 
              type="button"
              key={index}
              className={index <= rating ? "on" : "off"}
              onClick={() => setRating(index)}
            >
              <span className="star">&#9733;</span>
            </button>
          );
        })}
      </div>
    );
  };
  
export default class Feedback extends Component {

    state = {
        feedback: "",
    };

  render() {
      return (
      <Card className={"border border-dark"}>
        <Card.Header>
            <h1>Rate your flight!</h1>
        </Card.Header>

        <Card.Body style={{"textAlign":"left"}}>
            <Form id="feedbackId">
                <Form.Group className="mb-3">
                    <Form.Label>Flight Number</Form.Label>
                    <Form.Control required
                        type="text"
                        name={'flightNumber'}
                        placeholder="Enter flight number" />
                </Form.Group>

                <Form.Group className="mb-3">
                    <Form.Label>Flight</Form.Label>
                    <StarRating/>
                    <Form.Control 
                        type="feedback"
                        name="feedback"
                        placeholder="How was your overall impression of the flight? Let us know!" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Catering</Form.Label>
                    <StarRating/>
                    <Form.Control 
                        type="feedback"
                        name="feedback"
                        placeholder="Would you like to comment on the food quality? We're happy to hear your suggestions!" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Entertainment</Form.Label>
                    <StarRating/>
                    <Form.Control 
                        type="feedback"
                        name="feedback"
                        placeholder="Got any suggestions for our onboard entertainment system?" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Service</Form.Label>
                    <StarRating/>
                    <Form.Control 
                        type="feedback"
                        name="feedback"
                        placeholder="Your feedback is very valuable to improving out flight attendants quality of service!" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label>Comfort</Form.Label>
                    <StarRating/>
                    <Form.Control 
                        type="feedback"
                        name="feedback"
                        placeholder="How comfy was your seat? Let us know what we can improve upon!" />
                </Form.Group>
                <Button
                    size="sm"
                    variant="outline-success"
                    type="submit"
                    onClick={()=>alert("Thank you for your feedback! Your next drink is on us ;)")}>
                    Submit Feedback
                </Button>
                
            </Form>
        </Card.Body>
        </Card>
    );
  }
}