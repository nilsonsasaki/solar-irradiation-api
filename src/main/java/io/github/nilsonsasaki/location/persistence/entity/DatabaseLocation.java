package io.github.nilsonsasaki.location.persistence.entity;

import io.github.nilsonsasaki.source.persistence.entity.DatabaseSource;
import io.github.nilsonsasaki.user.persistence.entity.DatabaseUser;
import jakarta.persistence.*;

@Table(name = "t_location")
@Entity

public class DatabaseLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private DatabaseSource sourceId;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String country;

    @Column
    private String neighbourhood;

    @Column
    private String subDistrict;

    @Column
    private String district;

    @Column(nullable = false)
    private float latitude;

    @Column(nullable = false)
    private float longitude;

    @Column(nullable = false)
    private float altitude;

    @Column(nullable = false)
    private String createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private DatabaseUser createdBy;

    @Column(nullable = false)
    private String updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DatabaseSource getSourceId() {
        return sourceId;
    }

    public void setSourceId(DatabaseSource sourceId) {
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

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public DatabaseUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(DatabaseUser createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
