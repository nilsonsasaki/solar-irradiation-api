package io.github.nilsonsasaki.measure.domain.model;

import io.github.nilsonsasaki.enums.MeasureType;
import io.github.nilsonsasaki.exception.domain.IllegalNullArgumentException;

public class Measure {

    private long id;
    private long irradiationId;
    private long sourceId;
    private MeasureType measureType;
    private float annual;
    private float jan;
    private float feb;
    private float mar;
    private float apr;
    private float may;
    private float jun;
    private float jul;
    private float aug;
    private float sep;
    private float oct;
    private float nov;
    private float dec;

    public Measure(Long id, Long irradiationId,Long sourceId, Float annual, Float jan, Float feb,
                   Float mar, Float apr, Float may, Float jun, Float jul,
                   Float aug, Float sep, Float oct, Float nov, Float dec) {
        if (id == null) throw new IllegalNullArgumentException("id");
        if (irradiationId == null) throw new IllegalNullArgumentException("measureId");
        if (sourceId == null) throw new IllegalNullArgumentException("sourceId");
        if (annual == null) throw new IllegalNullArgumentException("annual");
        if (jan == null) throw new IllegalNullArgumentException("jan");
        if (feb == null) throw new IllegalNullArgumentException("feb");
        if (mar == null) throw new IllegalNullArgumentException("mar");
        if (apr == null) throw new IllegalNullArgumentException("apr");
        if (may == null) throw new IllegalNullArgumentException("may");
        if (jun == null) throw new IllegalNullArgumentException("jun");
        if (jul == null) throw new IllegalNullArgumentException("jul");
        if (aug == null) throw new IllegalNullArgumentException("aug");
        if (sep == null) throw new IllegalNullArgumentException("sep");
        if (oct == null) throw new IllegalNullArgumentException("oct");
        if (nov == null) throw new IllegalNullArgumentException("nov");
        if (dec == null) throw new IllegalNullArgumentException("dec");

        this.id = id;
        this.irradiationId = irradiationId;
        this.sourceId = sourceId;
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
    }

    public long getId() {
        return id;
    }

    public long getIrradiationId() {
        return irradiationId;
    }

    public void setIrradiationId(long irradiationId) {
        this.irradiationId = irradiationId;
    }

    public long getSourceId() {
        return sourceId;
    }

    public void setSourceId(long sourceId) {
        this.sourceId = sourceId;
    }

    public MeasureType getMeasureType() {
        return measureType;
    }

    public void setMeasureType(MeasureType measureType) {
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

    @Override
    public String toString() {
        return "Measure{" +
                "id=" + id +
                ", irradiationId=" + irradiationId +
                ", sourceId=" + sourceId +
                ", measureType=" + measureType +
                ", annual=" + annual +
                ", jan=" + jan +
                ", feb=" + feb +
                ", mar=" + mar +
                ", apr=" + apr +
                ", may=" + may +
                ", jun=" + jun +
                ", jul=" + jul +
                ", aug=" + aug +
                ", sep=" + sep +
                ", oct=" + oct +
                ", nov=" + nov +
                ", dec=" + dec +
                '}';
    }
}
