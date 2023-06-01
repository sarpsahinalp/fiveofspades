import React from 'react'
import { GoogleMap, useJsApiLoader } from '@react-google-maps/api';
import {GOOGLE_API} from "../../consts";

const containerStyle = {
    width: '100%',
    height: '710px'
};
const center = {
    lat: 48.2625718343,
    lng: 11.669929217
};

function MyComponent() {
    const { isLoaded } = useJsApiLoader({
        id: 'google-map-script',
        googleMapsApiKey: `${GOOGLE_API}`
    })

    const [map, setMap] = React.useState(null)

    const onLoad = React.useCallback(function callback(map:any) {
        const bounds = new window.google.maps.LatLngBounds(center);
        map.fitBounds(bounds);
        setMap(map)
    }, [])

    const onUnmount = React.useCallback(function callback(map:any) {
        setMap(null)
    }, [])

    return isLoaded ? (
        <GoogleMap
            mapContainerStyle={containerStyle}
            center={center}
            zoom={16}
            onLoad={onLoad}
            onUnmount={onUnmount}
        >
            { /* Child components, such as markers, info windows, etc. */ }

        </GoogleMap>
    ) : <></>
}

export default React.memo(MyComponent)