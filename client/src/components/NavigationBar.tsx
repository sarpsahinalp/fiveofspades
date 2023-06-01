import React from "react";
import { Navbar, Nav } from "react-bootstrap";
import { Link } from "react-router-dom";
const logo = require("../assets/logo.png");

class NavigationBar extends React.Component {
  render() {
    return (
        <Navbar bg="dark" variant="dark">
            <Link to={"/"} className={'navbar-brand'}>
                <img src={logo} width="30" height="30" className="d-inline-block align-top" alt=""/>
                Aeronautica
            </Link>
            <Nav className="mr-auto">
                <Link to={"/flights"} className="nav-link">Browse Flights</Link>
                <Link to={"/feedback"} className={"nav-link"}>Give Feedback</Link>
                <Link to={"/services"} className={"nav-link"}>Request Service</Link>
                <Link to={"/infighters"} className={"nav-link"}>In-Flight Video</Link>
                <Link to={"/mapTEST"} className={"nav-link"}>Map</Link>
                <Link to={"/watchMovie"} className={"nav-link"}>Watch Movie</Link>
                <Link to={"/login"} className={"nav-link"}>Log In</Link>
                <Link to={"/signup"} className={"nav-link"}>Sign Up</Link>
            </Nav>
               
            <Nav className="ms-auto">
                <Link to={"/login"} className={"nav-link"}>Log In</Link>
                <Link to={"/registration"} className={"nav-link"}>Registration</Link>
            </Nav>
        </Navbar>
    );
    }
}

export default NavigationBar;
