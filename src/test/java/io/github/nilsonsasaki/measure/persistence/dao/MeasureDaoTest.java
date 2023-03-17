package io.github.nilsonsasaki.measure.persistence.dao;

import io.github.nilsonsasaki.enums.MeasureType;
import io.github.nilsonsasaki.measure.persistence.entity.DatabaseMeasure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class MeasureDaoTest {

    @Autowired
    MeasureDao repository;

    @Test
    public void should_find_any_measure_if_repository_is_empty() {
        List<DatabaseMeasure> sources = repository.findAll();
        assertTrue(sources.isEmpty());
    }

    @Test
    public void should_store_measure(){
        DatabaseMeasure measure = repository.save(new DatabaseMeasure(
                null,
                null,
                MeasureType.GLOBAL_HORIZONTAL.toString(),
                6f, 1f,2f,3f,4f,5f,6f,7f,8f,9f,10f,11f,12f,
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                null,
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
        ));

        assertEquals(Optional.of(measure),repository.findById(measure.getId()));
    }
}
