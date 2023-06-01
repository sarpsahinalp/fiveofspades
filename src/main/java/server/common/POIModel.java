package server.common;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class POIModel {
    @Id
    @SequenceGenerator(
            name = "poi_sequence",
            sequenceName = "poi_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "poi_sequence"
    )

    private Long poiId;
    private String googleMapsId;
    private Float lat;
    private Float lng;
    private String name;
    //private String[] type;


    public POIModel() {
    }

    public POIModel(Long poiId, String googleMapsId, Float lat, Float lng, String name) {
        this.poiId = poiId;
        this.googleMapsId = googleMapsId;
        this.lat = lat;
        this.lng = lng;
        this.name = name;
    }

    public POIModel(String googleMapsId, Float lat, Float lng, String name) {
        this.googleMapsId = googleMapsId;
        this.lat = lat;
        this.lng = lng;
        this.name = name;
    }

    public Long getPoiId() {
        return poiId;
    }

    public void setPoiId(Long poiId) {
        this.poiId = poiId;
    }

    public String getGoogleMapsId() {
        return googleMapsId;
    }

    public void setGoogleMapsId(String googleMapsId) {
        this.googleMapsId = googleMapsId;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "POI{" +
                "id=" + poiId +
                ", googleMaps id='" + googleMapsId + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", name='" + name + '\'' +
                '}';
    }
}
