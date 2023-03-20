package io.github.nilsonsasaki.source.persistence.dao;

import io.github.nilsonsasaki.source.persistence.entity.DatabaseSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
public class SourceDaoTest {

    @Autowired
    SourceDao repository;

    @Test
    public void should_find_no_source_if_repository_is_empty() {
        List<DatabaseSource> sources = repository.findAll();
        assertTrue(sources.isEmpty());
    }

    @Test
    public void should_store_source() {
        DatabaseSource source = repository.save(new DatabaseSource(
                1L,
                "externalId",
                "Source",
                LocalDate.of(2023, Month.JANUARY, 24),
                "URL",
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                null,
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
        ));

        assertEquals(Optional.of(source), repository.findById(source.getId()));
        assertEquals("externalId", repository.findById(source.getId()).get().getExternalId());
        assertNotNull(source);
    }

    @Test
    public void should_find_by_id() {
        DatabaseSource source = repository.save(new DatabaseSource(
                1L,
                "externalId",
                "Source",
                LocalDate.of(2023, Month.JANUARY, 24),
                "URL",
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                null,
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
        ));
        assertEquals(Optional.of(source), repository.findById(source.getId()));
    }

    @Test
    public void should_find_by_externalId() {
        DatabaseSource source = new DatabaseSource(
                1L,
                "externalId",
                "Source",
                LocalDate.of(2023, Month.JANUARY, 24),
                "URL",
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                null,
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
        );
        repository.save(source);
        assertNotNull(source);
        assertEquals(Optional.of(source), repository.findByExternalId("externalId"));
    }

    @Test
    public void should_find_all_by_release_date() {
        DatabaseSource source = repository.save(new DatabaseSource(
                "externalId2",
                "Source",
                LocalDate.of(2023, Month.JANUARY, 24),
                "URL",
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                null,
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
        ));
        DatabaseSource source2 = repository.save(new DatabaseSource(
                "externalId3",
                "Source",
                LocalDate.of(2023, Month.JANUARY, 24),
                "URL",
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                null,
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
        ));
        List<DatabaseSource> sources = repository.findAllByReleaseDate(LocalDate.of(2023, Month.JANUARY, 24));
        assertEquals(2, sources.size());
        assertTrue(sources.contains(source));
        assertTrue(sources.contains(source2));
    }

    @Test
    public void should_find_latest_update() {
        DatabaseSource source = repository.save(new DatabaseSource(
                "externalId2",
                "Source",
                LocalDate.of(2023, Month.JANUARY, 24),
                "URL",
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                null,
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
        ));
        assertEquals(LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1), repository.findLatestUpdate());
    }
}
