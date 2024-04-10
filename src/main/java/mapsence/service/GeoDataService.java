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

    public List<GeoData> findAll() {
        return geoDataRepository.findAll();
    }
    public List<GeoData> findBySensor (Long id) {
        Optional<Sensor> sensor = sensorRepository.findById(id);
        return geoDataRepository.findBySensorId(sensor.orElseThrow(() -> new NoSuchElementException("User not found with id: " + id)));
    }

    public Optional<GeoData> findById (Long id) {
        return geoDataRepository.findById(id);
    }
}
