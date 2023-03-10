package io.github.nilsonsasaki.irradiation.domain.model;

import io.github.nilsonsasaki.exception.domain.IllegalNullArgumentException;

import java.util.List;

public class Irradiation {
    private long id;
    private long sourceId;
    private List<Long> measures;
    private String country;
    private float latitude;
    private float longitude;

    public Irradiation(Long id, Long sourceId, List<Long> measures, String country, Float latitude, Float longitude) {
        if (id == null) throw new IllegalNullArgumentException("id");
        if (sourceId == null) throw new IllegalNullArgumentException("sourceId");
        if (measures == null) throw new IllegalNullArgumentException("measures");
        if (country == null) throw new IllegalNullArgumentException("country");
        if (latitude == null) throw new IllegalNullArgumentException("latitude");
        if (longitude == null) throw new IllegalNullArgumentException("longitude");
        this.id = id;
        this.sourceId = sourceId;
        this.measures = measures;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public List<Long> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Long> measures) {
        this.measures = measures;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Irradiation{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

}
