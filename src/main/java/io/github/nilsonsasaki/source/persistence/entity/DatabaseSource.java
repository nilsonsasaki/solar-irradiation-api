package io.github.nilsonsasaki.source.persistence.entity;

import io.github.nilsonsasaki.user.persistence.entity.DatabaseUser;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "t_source")
@Entity
public class DatabaseSource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String externalId;

    @Column
    private String source;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate releaseDate;

    @Column
    private String url;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private DatabaseUser createdBy;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    public DatabaseSource() {
    }

    public DatabaseSource(String externalId, String source, LocalDate releaseDate, String url, LocalDateTime createdAt, DatabaseUser createdBy, LocalDateTime updatedAt) {
        this.externalId = externalId;
        this.source = source;
        this.releaseDate = releaseDate;
        this.url = url;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
    }

    public DatabaseSource(long id, String externalId, String source, LocalDate releaseDate, String url, LocalDateTime createdAt, DatabaseUser createdBy, LocalDateTime updatedAt) {
        this.id = id;
        this.externalId = externalId;
        this.source = source;
        this.releaseDate = releaseDate;
        this.url = url;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        DatabaseSource that = (DatabaseSource) o;
        return id == that.id && externalId.equals(that.externalId) && source.equals(that.source) && releaseDate.equals(that.releaseDate) && Objects.equals(url, that.url) && createdAt.equals(that.createdAt) && updatedAt.equals(that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, externalId, source, releaseDate, url, createdAt, updatedAt);
    }
}
