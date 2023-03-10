package io.github.nilsonsasaki.user.domain.model;

import io.github.nilsonsasaki.enums.Role;

import java.util.Objects;

public class User {

    private final Long id;
    private String name;
    private String email;
    private Role role;

    public User(Long id, String name, String email, Role role) {
        if (id == null) throw new NullPointerException("id cannot be null");
        if (name == null) throw new NullPointerException("name cannot be null");
        if (email == null) throw new NullPointerException("email cannot be null");
        if (role == null) throw new NullPointerException("role cannot be null");

        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
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
        return id.equals(user.id) && name.equals(user.name) && email.equals(user.email) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, role);
    }
}
