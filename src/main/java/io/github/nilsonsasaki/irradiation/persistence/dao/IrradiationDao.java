package io.github.nilsonsasaki.irradiation.persistence.dao;

import io.github.nilsonsasaki.irradiation.persistence.entity.DatabaseIrradiation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IrradiationDao extends JpaRepository<DatabaseIrradiation, Long> {

    Optional<DatabaseIrradiation> findByExternalId(String externalID);

    Optional<DatabaseIrradiation> findByLatitudeAndLongitude(float latitude, float Longitude);

    /*@Query(nativeQuery = true, value = " SELECT * FROM t_irradiation RIGHT JOIN t_measure ON t_irradiation.id = t_measure.irradiation_id WHERE t_irradiation.id = :id ")
    DatabaseIrradiation fetchMeasuresById(@Param("id") Long id);

    @Query(nativeQuery = false, value = " SELECT i FROM DatabaseIrradiation i LEFT JOIN FETCH i.measures WHERE i.externalId =:externalId")
    Optional<DatabaseIrradiation> fetchMeasuresByExternalId(@Param("externalId") String externalId);*/
}

