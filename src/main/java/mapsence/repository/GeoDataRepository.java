package mapsence.repository;

import mapsence.model.Sensor;
import mapsence.model.GeoData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeoDataRepository extends JpaRepository<GeoData, Long> {
    List<GeoData> findBySensorId(Long sensorId);
}
