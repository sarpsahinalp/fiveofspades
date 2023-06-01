
export default interface POIModel {
    poiId: number
    googleMapsId: string
    //add city

    lat: number
    lng: number

    name: string
    type: Array<string> //[restaurant, hotel]
}