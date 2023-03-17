package io.github.nilsonsasaki.irradiation.persistence.entity;

import io.github.nilsonsasaki.measure.persistence.entity.DatabaseMeasure;
import io.github.nilsonsasaki.source.persistence.entity.DatabaseSource;
import io.github.nilsonsasaki.user.persistence.entity.DatabaseUser;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "t_irradiation")
@Entity
public class DatabaseIrradiation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(unique = true)
    private String externalId;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private DatabaseSource sourceId;

    @OneToMany(mappedBy = "irradiationId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DatabaseMeasure> measures = new ArrayList<>();

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private float latitude;

    @Column(nullable = false)
    private float longitude;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private DatabaseUser createdBy;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;


    public DatabaseIrradiation() {
    }

    public DatabaseIrradiation(String externalId, DatabaseSource sourceId, List<DatabaseMeasure> measures,
                               String country, float latitude, float longitude,
                               LocalDateTime createdAt, DatabaseUser createdBy, LocalDateTime updatedAt) {
        this.externalId = externalId;
        this.sourceId = sourceId;
        this.measures = measures;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
    }

    public DatabaseIrradiation(long id, String externalId, DatabaseSource sourceId,
                               List<DatabaseMeasure> measures, String country, float latitude,
                               float longitude, LocalDateTime createdAt, DatabaseUser createdBy,
                               LocalDateTime updatedAt) {
        this.id = id;
        this.externalId = externalId;
        this.sourceId = sourceId;
        this.measures = measures;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<DatabaseMeasure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<DatabaseMeasure> measures) {
        this.measures = measures;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        DatabaseIrradiation that = (DatabaseIrradiation) o;
        return id == that.id && Float.compare(that.latitude, latitude) == 0 && Float.compare(that.longitude, longitude) == 0 && externalId.equals(that.externalId) && country.equals(that.country) && createdAt.equals(that.createdAt) && updatedAt.equals(that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalId, country, latitude, longitude, createdAt, updatedAt);
    }
}
