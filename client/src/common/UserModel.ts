import UserRoleEnum from "./util/UserRoleEnum"
import POIModel from "./POIModel"

export default interface UserModel {
    userId: number,
    name: string,
    email: string,
    password: string,
    birthDate: Date,
    userRoleEnum: UserRoleEnum,
    poiModels: Array<POIModel>
}