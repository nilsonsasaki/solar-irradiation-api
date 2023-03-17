package io.github.nilsonsasaki.location.persistence.dao;

import io.github.nilsonsasaki.location.persistence.entity.DatabaseLocation;
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
public class LocationDaoTest {

    @Autowired
    LocationDao repository;

    @Test
    public void should_find_any_location_if_repository_is_empty() {
        List<DatabaseLocation> locations = repository.findAll();
        assertTrue (locations.isEmpty());
    }

    @Test
    public void should_find_location_by_id() {
        DatabaseLocation location = repository.save(
                new DatabaseLocation(
                        "externalId", null,"locationName",
                        "city","state","country","neighbourhood",
                        "subDistrict","district",1f,-1f,1000f,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                        null,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
                )
        );
        assertEquals(Optional.of(location),repository.findById(location.getId()));
    }

    @Test
    public void should_find_location_by_externalId() {
        DatabaseLocation location = repository.save(
                new DatabaseLocation(
                        "externalId", null,"locationName",
                        "city","state","country","neighbourhood",
                        "subDistrict","district",1f,-1f,1000f,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                        null,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
                )
        );
        assertEquals(Optional.of(location),repository.findByExternalId(location.getExternalId()));
    }

    @Test
    public void should_find_all_by_location_name() {
        DatabaseLocation location = repository.save(
                new DatabaseLocation(
                        "externalId", null,"locationName",
                        "city","state","country","neighbourhood",
                        "subDistrict","district",1f,-1f,1000f,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                        null,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
                )
        );
        DatabaseLocation location2 = repository.save(
                new DatabaseLocation(
                        "externalId2", null,"LocationName",
                        "city","state","country","neighbourhood",
                        "subDistrict","district",1f,-1f,1000f,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                        null,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
                )
        );
        List<DatabaseLocation> locations = repository.findAllByLocationNameStartsWithIgnoreCase("location");
        assertEquals(2, locations.size());
        assertEquals(location.getLocationName(),locations.get(0).getLocationName());
        assertEquals(location2.getLocationName(),locations.get(1).getLocationName());
    }

    @Test
    public void should_find_all_by_city() {
        DatabaseLocation location = repository.save(
                new DatabaseLocation(
                        "externalId", null,"locationName",
                        "city","state","country","neighbourhood",
                        "subDistrict","district",1f,-1f,1000f,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                        null,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
                )
        );
        DatabaseLocation location2 = repository.save(
                new DatabaseLocation(
                        "externalId2", null,"LocationName",
                        "City","state","country","neighbourhood",
                        "subDistrict","district",1f,-1f,1000f,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                        null,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
                )
        );
        List<DatabaseLocation> locations = repository.findAllByCityStartsWithIgnoreCase("city");
        assertEquals(2, locations.size());
        assertEquals(location.getLocationName(),locations.get(0).getLocationName());
        assertEquals(location2.getLocationName(),locations.get(1).getLocationName());
    }

    @Test
    public void should_find_all_by_city_and_state() {
        DatabaseLocation location = repository.save(
                new DatabaseLocation(
                        "externalId", null,"locationName",
                        "city","state","country","neighbourhood",
                        "subDistrict","district",1f,-1f,1000f,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                        null,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
                )
        );
        DatabaseLocation location2 = repository.save(
                new DatabaseLocation(
                        "externalId2", null,"LocationName",
                        "City","State","country","neighbourhood",
                        "subDistrict","district",1f,-1f,1000f,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                        null,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
                )
        );
    List<DatabaseLocation> locations = repository.findAllByCityAndState("city","state");
        assertEquals(2, locations.size());
        assertEquals(location,locations.get(0));
        assertEquals(location2,locations.get(1));
    }

    @Test
    public void should_find_all_by_city_and_state_and_location() {
        DatabaseLocation location = repository.save(
                new DatabaseLocation(
                        "externalId", null,"locationName",
                        "city","state","country","neighbourhood",
                        "subDistrict","district",1f,-1f,1000f,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                        null,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
                )
        );
        DatabaseLocation location2 = repository.save(
                new DatabaseLocation(
                        "externalId2", null,"LocationName",
                        "City","State","Country","Neighbourhood",
                        "SubDistrict","District",1f,-1f,1000f,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                        null,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
                )
        );
        List<DatabaseLocation> locations = repository.findAllByCityAndStateAndLocationName("city","state","location");
        assertEquals(2, locations.size());
        assertEquals(location,locations.get(0));
        assertEquals(location2,locations.get(1));
    }

    @Test
    public void should_find_all_by_city_and_neighbourhood() {
        DatabaseLocation location = repository.save(
                new DatabaseLocation(
                        "externalId", null,"locationName",
                        "city","state","country","neighbourhood",
                        "subDistrict","district",1f,-1f,1000f,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                        null,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
                )
        );
        DatabaseLocation location2 = repository.save(
                new DatabaseLocation(
                        "externalId2", null,"LocationName",
                        "City","State","country","Neighbourhood",
                        "subDistrict","district",1f,-1f,1000f,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                        null,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
                )
        );
        List<DatabaseLocation> locations = repository.findAllByCityAndStateAndNeighbourhood("city","state", "neighbourhood");
        assertEquals(2, locations.size());
        assertEquals(location,locations.get(0));
        assertEquals(location2,locations.get(1));
    }

    @Test
    public void should_find_all_by_city_and_district() {
        DatabaseLocation location = repository.save(
                new DatabaseLocation(
                        "externalId", null,"locationName",
                        "city","state","country","neighbourhood",
                        "subDistrict","district",1f,-1f,1000f,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                        null,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
                )
        );
        DatabaseLocation location2 = repository.save(
                new DatabaseLocation(
                        "externalId2", null,"LocationName",
                        "City","State","country","Neighbourhood",
                        "subDistrict","district",1f,-1f,1000f,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                        null,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
                )
        );
        List<DatabaseLocation> locations = repository.findAllByCityAndStateAndDistrict("city","state", "district");
        assertEquals(2, locations.size());
        assertEquals(location,locations.get(0));
        assertEquals(location2,locations.get(1));
    }

    @Test
    public void should_find_all_by_city_and_sub_district() {
        DatabaseLocation location = repository.save(
                new DatabaseLocation(
                        "externalId", null,"locationName",
                        "city","state","country","neighbourhood",
                        "subDistrict","district",1f,-1f,1000f,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                        null,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
                )
        );
        DatabaseLocation location2 = repository.save(
                new DatabaseLocation(
                        "externalId2", null,"LocationName",
                        "City","State","country","Neighbourhood",
                        "subDistrict","district",1f,-1f,1000f,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1),
                        null,
                        LocalDateTime.of(2023, Month.MAY, 13, 23, 59, 1)
                )
        );
        List<DatabaseLocation> locations = repository.findAllByCityAndStateAndSubDistrict("city","state", "subDistrict");
        assertEquals(2, locations.size());
        assertEquals(location,locations.get(0));
        assertEquals(location2,locations.get(1));
    }



}
