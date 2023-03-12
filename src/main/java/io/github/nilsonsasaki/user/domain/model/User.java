package io.github.nilsonsasaki.user.domain.model;

import io.github.nilsonsasaki.enums.Role;
import io.github.nilsonsasaki.exception.domain.IllegalNullArgumentException;

import java.util.Objects;

public class User {

    private Long id;
    private String externalId;
    private String name;
    private String email;
    private Role role;

    public User(Long id, String externalId, String name, String email, Role role) {
        if (id == null) throw new IllegalNullArgumentException("id");
        if (externalId == null) throw new IllegalNullArgumentException("externalId");
        if (name == null) throw new IllegalNullArgumentException("name");
        if (email == null) throw new IllegalNullArgumentException("email");
        if (role == null) throw new IllegalNullArgumentException("role");

        this.id = id;
        this.externalId = externalId;
        this.name = name;
        this.email = email;
        this.role = role;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && externalId.equals(user.externalId) && name.equals(user.name) && email.equals(user.email) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalId, name, email, role);
    }
}
