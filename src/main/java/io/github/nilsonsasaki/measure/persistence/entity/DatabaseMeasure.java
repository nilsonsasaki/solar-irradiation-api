package io.github.nilsonsasaki.measure.persistence.entity;

import io.github.nilsonsasaki.irradiation.persistence.entity.DatabaseIrradiation;
import io.github.nilsonsasaki.source.persistence.entity.DatabaseSource;
import io.github.nilsonsasaki.user.persistence.entity.DatabaseUser;
import jakarta.persistence.*;

import java.util.Objects;

@Table(name = "t_measure")
@Entity
public class DatabaseMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "irradiation_id")
    private DatabaseIrradiation irradiationId;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private DatabaseSource sourceId;

    @Column(nullable = false)
    private String measureType;

    @Column(nullable = false)
    private float annual;

    @Column(nullable = false)
    private float jan;

    @Column(nullable = false)
    private float feb;

    @Column(nullable = false)
    private float mar;

    @Column(nullable = false)
    private float apr;

    @Column(nullable = false)
    private float may;

    @Column(nullable = false)
    private float jun;

    @Column(nullable = false)
    private float jul;

    @Column(nullable = false)
    private float aug;

    @Column(nullable = false)
    private float sep;

    @Column(nullable = false)
    private float oct;

    @Column(nullable = false)
    private float nov;

    @Column(nullable = false)
    private float dec;

    @Column(nullable = false)
    private String createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private DatabaseUser createdBy;

    @Column(nullable = false)
    private String updatedAt;

    public DatabaseMeasure() {
    }

    public DatabaseMeasure(long id, DatabaseIrradiation irradiationId,
                           DatabaseSource sourceId, String measureType,
                           float annual, float jan, float feb, float mar,
                           float apr, float may, float jun, float jul,
                           float aug, float sep, float oct, float nov,
                           float dec, String createdAt, DatabaseUser createdBy,
                           String updatedAt) {
        this.id = id;
        this.irradiationId = irradiationId;
        this.sourceId = sourceId;
        this.measureType = measureType;
        this.annual = annual;
        this.jan = jan;
        this.feb = feb;
        this.mar = mar;
        this.apr = apr;
        this.may = may;
        this.jun = jun;
        this.jul = jul;
        this.aug = aug;
        this.sep = sep;
        this.oct = oct;
        this.nov = nov;
        this.dec = dec;
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

    public DatabaseIrradiation getIrradiationId() {
        return irradiationId;
    }

    public void setIrradiationId(DatabaseIrradiation irradiationId) {
        this.irradiationId = irradiationId;
    }

    public DatabaseSource getSourceId() {
        return sourceId;
    }

    public void setSourceId(DatabaseSource sourceId) {
        this.sourceId = sourceId;
    }

    public String getMeasureType() {
        return measureType;
    }

    public void setMeasureType(String measureType) {
        this.measureType = measureType;
    }

    public float getAnnual() {
        return annual;
    }

    public void setAnnual(float annual) {
        this.annual = annual;
    }

    public float getJan() {
        return jan;
    }

    public void setJan(float jan) {
        this.jan = jan;
    }

    public float getFeb() {
        return feb;
    }

    public void setFeb(float feb) {
        this.feb = feb;
    }

    public float getMar() {
        return mar;
    }

    public void setMar(float mar) {
        this.mar = mar;
    }

    public float getApr() {
        return apr;
    }

    public void setApr(float apr) {
        this.apr = apr;
    }

    public float getMay() {
        return may;
    }

    public void setMay(float may) {
        this.may = may;
    }

    public float getJun() {
        return jun;
    }

    public void setJun(float jun) {
        this.jun = jun;
    }

    public float getJul() {
        return jul;
    }

    public void setJul(float jul) {
        this.jul = jul;
    }

    public float getAug() {
        return aug;
    }

    public void setAug(float aug) {
        this.aug = aug;
    }

    public float getSep() {
        return sep;
    }

    public void setSep(float sep) {
        this.sep = sep;
    }

    public float getOct() {
        return oct;
    }

    public void setOct(float oct) {
        this.oct = oct;
    }

    public float getNov() {
        return nov;
    }

    public void setNov(float nov) {
        this.nov = nov;
    }

    public float getDec() {
        return dec;
    }

    public void setDec(float dec) {
        this.dec = dec;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatabaseMeasure that = (DatabaseMeasure) o;
        return id == that.id && Float.compare(that.annual, annual) == 0 && Float.compare(that.jan, jan) == 0 && Float.compare(that.feb, feb) == 0 && Float.compare(that.mar, mar) == 0 && Float.compare(that.apr, apr) == 0 && Float.compare(that.may, may) == 0 && Float.compare(that.jun, jun) == 0 && Float.compare(that.jul, jul) == 0 && Float.compare(that.aug, aug) == 0 && Float.compare(that.sep, sep) == 0 && Float.compare(that.oct, oct) == 0 && Float.compare(that.nov, nov) == 0 && Float.compare(that.dec, dec) == 0 && irradiationId.equals(that.irradiationId) && sourceId.equals(that.sourceId) && measureType.equals(that.measureType) && createdAt.equals(that.createdAt) && createdBy.equals(that.createdBy) && updatedAt.equals(that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, irradiationId, sourceId, measureType, annual, jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec, createdAt, createdBy, updatedAt);
    }
}
