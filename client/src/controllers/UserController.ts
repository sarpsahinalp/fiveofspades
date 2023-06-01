import axios from "axios";
import UserModel from "../common/UserModel";
import { SERVER_URL } from "../consts";

let axiosApi = axios.create({baseURL:SERVER_URL});

export const getUser = async (email:string, password:string) : Promise<UserModel> => {
    let res = await axiosApi.get(`login`);
    console.log(res.data);
    return res.data;
}


export const createUser = async (userModel:UserModel) => {
    let json = JSON.stringify(userModel);
    let res = await axiosApi.post(json);
    return res.status;
}