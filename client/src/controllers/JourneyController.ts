import axios from "axios";
import FlightModel from "../common/FlightModel";
import { SERVER_URL } from "../consts";

let axiosApi = axios.create({baseURL:SERVER_URL});

//TODO
export const getJourney  = async (journeyId:number) : Promise<FlightModel[]> => {
    let res = await axiosApi.get(`/journey/${journeyId}`);
    return res.data;
}

//input is an array of the flight ids
export const createJourney = async (journey:Array<number>) => {
    let json = JSON.stringify(journey);
    let res = await axiosApi.post(`/journey/`, json);
    return res.status;
}

export const updateJourney = async (journeyId: number, journey:Array<number>) => {
    let json = JSON.stringify(journey);
    let res = await axiosApi.put(`/journey/${journeyId}`,json);
    return res.status;
}

export const deleteJourney = async (journeyId: number) => {
    let res = await axiosApi.delete(`/journey/${journeyId}`);
    return res.status;
}