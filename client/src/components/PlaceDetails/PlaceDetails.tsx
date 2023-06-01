import React from "react";

const PlaceDetails = ({place} : any) => {
    //display the place details
    return (
        <div>
            <h1>{place.name}</h1>
        </div>
    );
}

export default PlaceDetails;