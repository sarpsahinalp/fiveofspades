import axios from "axios";
import FlightModel from "../common/FlightModel";
import FlightStatusEnum from "../common/util/FlightStatusEnum";
import {SERVER_URL} from "../consts"
import { normalFlight, normalFlight2, normalFlight3, delayedFlight, cancelledFlight ,orderArr} from "../dummyData";

export default interface flightCreateModel{
    flightId: number,
    fromId: string,
    toId: string,
    departureTime: Date,
    landingTime: Date,
    terminal: string,
    airplaneTypeId: string,
    airlineId: string,
    flightStatus: FlightStatusEnum
}
//todo:
//  users put their own seat - basically send a (userId,flightId,seat) post method to book a flight

let USE_DUMMY = false;

let axiosApi = axios.create({baseURL:SERVER_URL});

export const createFlight = async (flightCreateModel:flightCreateModel) => {
    let json = JSON.stringify(flightCreateModel);
    let res = await axiosApi.post("/flight",json);
    return res.status;
}

export const updateFlight = async (flightCreateModel:flightCreateModel) => {
    let json = JSON.stringify(flightCreateModel);
    let res = await axiosApi.put("/flight",json);
    return res.status;
}

//TODO
export const getFlight = async (flightId:number) : Promise<FlightModel> => {
    if(USE_DUMMY){
        return orderArr[flightId];
    }
    let res = await axiosApi.get(`/flight/${flightId}`);
    console.log(res.data);
    console.log(orderArr[flightId]);
    return res.data;
}

//gets the Nth flight of an user. The 0th flight is the next one.
export const getUserNthFlight = async (userId:number,flightIndex:number) : Promise<FlightModel> => {
    let res = await axiosApi.get(`/users/${userId}/flightIndex/${flightIndex}`);
    return res.data;
}

export const getUserNextFlight = async (userId:number) : Promise<FlightModel> => {
    return getUserNthFlight(userId,0);
}

export const deleteFlight = async (flightId:number) => {
    let res = await axiosApi.delete(`/flight/${flightId}`);
    return res.status;
}

export const getAllFlights = async () : Promise<FlightModel[]> => {
    if(USE_DUMMY){
        return [normalFlight, normalFlight2, normalFlight3, delayedFlight, cancelledFlight];
    }
    else{
        let res = await axiosApi.get("/flight");
        console.log(res);
        return res.data;
    }
}



