package io.github.nilsonsasaki.location.persistence.dao;

import io.github.nilsonsasaki.location.persistence.entity.DatabaseLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationDao extends JpaRepository<DatabaseLocation, Long> {

    Optional<DatabaseLocation> findByExternalId(String externalId);

    @Query(nativeQuery = true, value = (" SELECT * FROM t_location " +
            "WHERE LOWER(location_name) LIKE LOWER(CONCAT(:name, '%')) "))
    List<DatabaseLocation> findAllByLocationNameStartsWithIgnoreCase(@Param("name") String name);

    List<DatabaseLocation> findAllByCityStartsWithIgnoreCase(String city);

    @Query(nativeQuery = true, value = " SELECT * FROM t_location " +
            "WHERE LOWER(city) LIKE LOWER(CONCAT(:city, '%')) " +
            "AND LOWER(state) LIKE LOWER(CONCAT(:state,'%')) ")
    List<DatabaseLocation> findAllByCityAndState(@Param("city") String city,@Param("state") String state);

    @Query(nativeQuery = true,value = " SELECT * FROM t_location " +
            "WHERE LOWER(city) LIKE LOWER(CONCAT(:city,'%'))" +
            "AND LOWER(state) LIKE LOWER(CONCAT(:state,'%'))" +
            "AND LOWER(location_name) LIKE LOWER(CONCAT(:locationName,'%'))")
    List<DatabaseLocation> findAllByCityAndStateAndLocationName(@Param("city") String city,
                                                            @Param("state") String State,
                                                            @Param("locationName") String locationName);

    @Query(nativeQuery = true,value = " SELECT * FROM t_location " +
            "WHERE LOWER(city) LIKE LOWER(CONCAT(:city,'%'))" +
            "AND LOWER(state) LIKE LOWER(CONCAT(:state,'%'))" +
            "AND LOWER(neighbourhood) LIKE LOWER(CONCAT(:neighbourhood,'%'))")
    List<DatabaseLocation> findAllByCityAndStateAndNeighbourhood(@Param("city") String city,
                                                                 @Param("state") String State,
                                                                 @Param("neighbourhood") String neighbourhood);

    @Query(nativeQuery = true,value = " SELECT * FROM t_location " +
            "WHERE LOWER(city) LIKE LOWER(CONCAT(:city,'%'))" +
            "AND LOWER(state) LIKE LOWER(CONCAT(:state,'%'))" +
            "AND LOWER(district) LIKE LOWER(CONCAT(:district,'%'))")
    List<DatabaseLocation> findAllByCityAndStateAndDistrict(@Param("city") String city,
                                                            @Param("state") String state,
                                                            @Param("district") String district);

    @Query(nativeQuery = true,value = " SELECT * FROM t_location " +
            "WHERE LOWER(city) LIKE LOWER(CONCAT(:city,'%'))" +
            "AND LOWER(state) LIKE LOWER(CONCAT(:state,'%'))" +
            "AND LOWER(sub_district) LIKE LOWER(CONCAT(:subDistrict,'%'))")
    List<DatabaseLocation> findAllByCityAndStateAndSubDistrict(@Param("city") String city,
                                                               @Param("state") String state,
                                                               @Param("subDistrict") String subDistrict);
}
