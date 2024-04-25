package mapsence.service;

import lombok.RequiredArgsConstructor;
import mapsence.model.GeoData;
import mapsence.model.Sensor;
import mapsence.repository.GeoDataRepository;
import mapsence.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GeoDataService {
    private final GeoDataRepository geoDataRepository;
    private final SensorRepository sensorRepository;

    public List<GeoData> findBySensorId (Long sensor_id) {
        return geoDataRepository.findBySensorId(sensor_id);
    }
}
