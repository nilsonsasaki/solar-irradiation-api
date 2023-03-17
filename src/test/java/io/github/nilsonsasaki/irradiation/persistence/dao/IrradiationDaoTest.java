package io.github.nilsonsasaki.irradiation.persistence.dao;

import io.github.nilsonsasaki.irradiation.persistence.entity.DatabaseIrradiation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class IrradiationDaoTest {

    @Autowired
    IrradiationDao irradiationDao;

    @Test
    public void should_find_any_Irradiation_if_repository_is_empty() {
        List<DatabaseIrradiation> irradiation = irradiationDao.findAll();
        assertTrue(irradiation.isEmpty());
    }

    @Test
    public void find_by_external_id() {
        DatabaseIrradiation databaseIrradiation = irradiationDao.save(new DatabaseIrradiation(
                "externalId", null, Collections.emptyList(), "country",
                1f, 1f, LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                null,
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
        ));

        assertEquals(Optional.of(databaseIrradiation), irradiationDao.findByExternalId(databaseIrradiation.getExternalId()));
    }

    @Test
    public void find_by_latitude_and_longitude() {
        DatabaseIrradiation databaseIrradiation = irradiationDao.save(new DatabaseIrradiation(
                "externalId", null, Collections.emptyList(), "country",
                1f, 1f, LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                null,
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
        ));

        assertEquals(Optional.of(databaseIrradiation), irradiationDao.findByLatitudeAndLongitude(databaseIrradiation.getLatitude(), databaseIrradiation.getLongitude()));
    }

    /*@Test
    public void should_fetch_and_find_all_measures_of_an_irradiation_by_id() {
        DatabaseIrradiation databaseIrradiation = irradiationDao.save(new DatabaseIrradiation(
                "externalId", null, Collections.emptyList(), "country",
                1f, 1f, LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                null,
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
        ));

        DatabaseMeasure measure = measureDao.save(new DatabaseMeasure(
                databaseIrradiation,
                null,
                MeasureType.GLOBAL_HORIZONTAL.toString(),
                6f, 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f, 11f, 12f,
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                null,
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
        ));

    }

    @Test
    public void should_fetch_and_find_all_measures_of_an_irradiation_by_external_Id() {
        DatabaseIrradiation databaseIrradiation = irradiationDao.saveAndFlush(new DatabaseIrradiation(
                "externalId", null, Collections.emptyList(), "country",
                1f, 1f, LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                null,
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
        ));

        DatabaseMeasure measure = measureDao.saveAndFlush(new DatabaseMeasure(
                databaseIrradiation,
                null,
                MeasureType.GLOBAL_HORIZONTAL.toString(),
                6f, 1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f, 11f, 12f,
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                null,
                LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
        ));

    }*/
}
