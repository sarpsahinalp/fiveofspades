import axios from "axios";
import {NotificationModel} from "../common/NotificationModel";
import FlightStatusEnum from "../common/util/FlightStatusEnum";
import { SERVER_URL } from "../consts";

let axiosApi = axios.create({baseURL:SERVER_URL});

enum notificationType {
    FOR_CUSTOMER = 0,
    FOR_STAFF = 1
}

interface flightStatusNotificationCreateModel {
    notificationType: notificationType,
    flightId: number,
    delayMinutes?: number,
    flightStatus?: FlightStatusEnum,
}

//Gets the notifications for any user type - customer or staff.
export const getNotifications = async (userId:number) : Promise<NotificationModel[]> => {
    let res = await axiosApi.get(`/notifications/user/${userId}`);
    return res.data;
}

export const createDelayedNotification = async (flightId: number, delayMinutes: number) => {
    let notification : flightStatusNotificationCreateModel = {flightId: flightId, delayMinutes: delayMinutes, flightStatus: FlightStatusEnum.DELAYED, notificationType: notificationType.FOR_CUSTOMER} 
    let json = JSON.stringify(notification);
    let res = await axiosApi.post(`/notifications/`,json);
    return res.status;
}

export const createCanceledNotification = async (flightId: number) => {
    let notification : flightStatusNotificationCreateModel = {flightId: flightId, flightStatus: FlightStatusEnum.CANCELED, notificationType: notificationType.FOR_CUSTOMER} 
    let json = JSON.stringify(notification);
    let res = await axiosApi.post(`/notifications/`,json);
    return res.status;
}

export const createServiceRequestedNotification = async (flightId: number) => {
    let notification : flightStatusNotificationCreateModel = {flightId: flightId, notificationType: notificationType.FOR_STAFF} 
    let json = JSON.stringify(notification);
    let res = await axiosApi.post(`/notifications/`,json);
    return res.status;
}

export const deleteNotification = async (notificationId: number) => {
    let res = await axiosApi.delete(`/notifications/${notificationId}`);
    return res.status;
}