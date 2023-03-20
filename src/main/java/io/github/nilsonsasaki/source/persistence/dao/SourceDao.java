package io.github.nilsonsasaki.source.persistence.dao;

import io.github.nilsonsasaki.source.persistence.entity.DatabaseSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SourceDao extends JpaRepository<DatabaseSource, Long> {

    Optional<DatabaseSource> findByExternalId(String externalId);

    List<DatabaseSource> findAllByReleaseDate(LocalDate localDate);

    @Query("SELECT u.updatedAt FROM DatabaseSource u order by u.updatedAt desc LIMIT 1")
    LocalDateTime findLatestUpdate();

}
