package io.github.nilsonsasaki.location.domain.model;

import io.github.nilsonsasaki.exception.domain.IllegalNullArgumentException;

public class Location {

    private Long id;
    private long sourceId;
    private String location;
    private String city;
    private String state;
    private String country;
    private String neighbourhood;
    private String subDistrict;
    private String district;
    private float latitude;
    private float longitude;
    private float altitude;

    public Location(Long id, Long sourceId, String location, String city,
                    String state, String country, String neighbourhood, String subDistrict,
                    String district, Float latitude, Float longitude, Float altitude) {
        if (id == null) throw new IllegalNullArgumentException("id");
        if (location == null) throw new IllegalNullArgumentException("location");
        if (city == null) throw new IllegalNullArgumentException("city");
        if (state == null) throw new IllegalNullArgumentException("state");
        if (country == null) throw new IllegalNullArgumentException("country");
        if (latitude == null) throw new IllegalNullArgumentException("latitude");
        if (longitude == null) throw new IllegalNullArgumentException("longitude");
        if (altitude == null) throw new IllegalNullArgumentException("altitude");

        this.id = id;
        this.sourceId = sourceId;
        this.location = location;
        this.city = city;
        this.state = state;
        this.country = country;
        this.neighbourhood = neighbourhood;
        this.subDistrict = subDistrict;
        this.district = district;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public long getId() {
        return id;
    }

    public long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getSubDistrict() {
        return subDistrict;
    }

    public void setSubDistrict(String subDistrict) {
        this.subDistrict = subDistrict;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(Float altitude) {
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                '}';
    }
}
