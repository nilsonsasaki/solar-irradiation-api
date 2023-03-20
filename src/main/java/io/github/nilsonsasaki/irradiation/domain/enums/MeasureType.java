package io.github.nilsonsasaki.irradiation.domain.enums;

public enum MeasureType {
    GLOBAL_HORIZONTAL("ghm"),
    DIRECT_NORMAL("dni"),
    TILTED_SURFACE("tsi"),
    DIFFUSE("dif"),
    PHOTOSYNTHETICALLY_ACTIVE("par");

    private final String value;

    MeasureType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
