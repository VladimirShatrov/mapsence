package mapsence.service;


import lombok.RequiredArgsConstructor;
import mapsence.model.GeoData;
import mapsence.model.Sensor;
import mapsence.repository.GeoDataRepository;
import mapsence.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SensorService {
    private final SensorRepository sensorRepository;
    private final GeoDataRepository geoDataRepository;

    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    public GeoData currentGeoDataOfSensor(Long sensorId) {
        return geoDataRepository.findFirstBySensorIdOrderByDateTimeDesc(sensorId);
    }
}