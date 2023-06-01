import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import FlightInfo from '../components/FlightInfos/FlightInfo';
import {normalFlight} from '../dummyData';

function FlightInfoTester() {
    return (
        <FlightInfo flightModel={normalFlight} />
    );
  }
  
  export default FlightInfoTester;