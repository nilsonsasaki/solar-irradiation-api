package io.github.nilsonsasaki.measure.persistence.dao;

import io.github.nilsonsasaki.measure.persistence.entity.DatabaseMeasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MeasureDao extends JpaRepository<DatabaseMeasure, Long> {

}
