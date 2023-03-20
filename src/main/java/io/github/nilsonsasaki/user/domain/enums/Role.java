package io.github.nilsonsasaki.user.domain.enums;

public enum Role {
    ADMIN("Adm"),
    STANDARD("Std"),
    VIP("Vip");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}



