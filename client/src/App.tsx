import './App.css';
import React from 'react';
import NavigationBar from "./components/NavigationBar";
import Welcome from "./components/Welcome";
import FlightList from "./components/FlightList";
import ServicesAvailable from "./components/ServicesAvailable";
import Feedback from "./components/Feedback";
import {Col, Container, Row} from 'react-bootstrap';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import { GOOGLE_API } from './consts';
import FlightInfoTester from './views/FlightInfoTester';
import FlightView from './components/FlightView';
import InflightVideo from "./components/InflightVideo";
import WatchMovie from "./components/WatchMovie";
import MapContainer from "./components/MapContainer";
import Login from './views/Login';
import Register from './views/Register';

function App() {
  return (
    <Router>
        <div className="App">
            <NavigationBar />
            <Container>
            <Row>
                <Col>
                    <Routes>
                        <Route path="/" element={<Welcome />} />
                        <Route path="/mapTEST" element={<MapContainer/>} />
                        <Route path="/flightTEST" element={<FlightInfoTester/>} />
                        <Route path="/flights" element={<FlightList />} />
                        <Route path="/flights/:flightId" element={<FlightView />} />
                        <Route path="/services" element={<ServicesAvailable />} />
                        <Route path="/feedback" element={<Feedback />} />
                        <Route path="/infighters" element={<InflightVideo />} />
                        <Route path="/watchMovie" element={<WatchMovie />} />
                        <Route path="/login" element={<Login/>}/>
                        <Route path="/signup" element={<Register/>}/>
                    </Routes>
                </Col>
            </Row>
            </Container>
        </div>
        <script async
            src={`https://maps.googleapis.com/maps/api/js?key=${GOOGLE_API}&libraries=places&callback=initMap`}>
        </script>

    </Router>
  );
}

export default App;
