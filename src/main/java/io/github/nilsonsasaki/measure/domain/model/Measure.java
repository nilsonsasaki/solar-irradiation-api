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

    public Measure(Long id, Long irradiationId, Float annual, Float jan, Float feb,
                   Float mar, Float apr, Float may, Float jun, Float jul,
                   Float aug, Float sep, Float oct, Float nov, Float dec) {
        if (id == null) throw new IllegalNullArgumentException("id");
        if (irradiationId == null) throw new IllegalNullArgumentException("measureId");
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

    @Override
    public String toString() {
        return "Measure{" +
                "id=" + id +
                ", measureId=" + irradiationId +
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
