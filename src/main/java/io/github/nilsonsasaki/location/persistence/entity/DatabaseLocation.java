package io.github.nilsonsasaki.location.persistence.entity;

import io.github.nilsonsasaki.source.persistence.entity.DatabaseSource;
import io.github.nilsonsasaki.user.persistence.entity.DatabaseUser;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "t_location")
@Entity

public class DatabaseLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String externalId;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private DatabaseSource sourceId;

    @Column(nullable = false)
    private String locationName;

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
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private DatabaseUser createdBy;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    public DatabaseLocation() {
    }

    public DatabaseLocation(String externalId, DatabaseSource sourceId, String locationName, String city, String state, String country, String neighbourhood, String subDistrict, String district, float latitude, float longitude, float altitude, LocalDateTime createdAt, DatabaseUser createdBy, LocalDateTime updatedAt) {
        this.externalId = externalId;
        this.sourceId = sourceId;
        this.locationName = locationName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.neighbourhood = neighbourhood;
        this.subDistrict = subDistrict;
        this.district = district;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
    }

    public DatabaseLocation(Long id, String externalId, DatabaseSource sourceId, String locationName, String city, String state, String country, String neighbourhood, String subDistrict, String district, float latitude, float longitude, float altitude, LocalDateTime createdAt, DatabaseUser createdBy, LocalDateTime updatedAt) {
        this.id = id;
        this.externalId = externalId;
        this.sourceId = sourceId;
        this.locationName = locationName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.neighbourhood = neighbourhood;
        this.subDistrict = subDistrict;
        this.district = district;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public DatabaseSource getSourceId() {
        return sourceId;
    }

    public void setSourceId(DatabaseSource sourceId) {
        this.sourceId = sourceId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DatabaseUser getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(DatabaseUser createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatabaseLocation that = (DatabaseLocation) o;
        return Float.compare(that.latitude, latitude) == 0 && Float.compare(that.longitude, longitude) == 0 && Float.compare(that.altitude, altitude) == 0 && id.equals(that.id) && externalId.equals(that.externalId) && locationName.equals(that.locationName) && city.equals(that.city) && state.equals(that.state) && country.equals(that.country) && Objects.equals(neighbourhood, that.neighbourhood) && Objects.equals(subDistrict, that.subDistrict) && Objects.equals(district, that.district) && createdAt.equals(that.createdAt) && updatedAt.equals(that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalId, locationName, city, state, country, neighbourhood, subDistrict, district, latitude, longitude, altitude, createdAt, updatedAt);
    }
}
