import React from "react";
import {CssBaseline, Grid} from "@material-ui/core";

import MapHeader from "./MapHeader/MapHeader";
import PlaceList from "./PlaceList/PlaceList";
import Map from "./Map/Map";

const MapContainer = () => {
    return (
        <>
            <CssBaseline/>
            <MapHeader/>
            <Grid container spacing={3} style={{ width : '100%'}}>
                <Grid item xs={12} md={4}>
                    <PlaceList/>
                </Grid>
                <Grid item xs={12} md={8}>
                    <Map/>
                </Grid>
            </Grid>
        </>
    );
}

    export default MapContainer;