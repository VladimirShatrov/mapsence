package mapsence.repository;

import mapsence.model.GeoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeoDataRepository extends JpaRepository<GeoData, Long> {
    List<GeoData> findBySensorId(Long sensorId);

    GeoData findFirstBySensorIdOrderByDateTimeDesc(Long sensorId);
}
