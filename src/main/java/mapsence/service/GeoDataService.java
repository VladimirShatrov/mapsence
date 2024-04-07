package mapsence.service;

import lombok.RequiredArgsConstructor;
import mapsence.model.GeoData;
import mapsence.model.Sensor;
import mapsence.model.Track;
import mapsence.repository.GeoDataRepository;
import mapsence.repository.SensorRepository;
import mapsence.repository.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GeoDataService {
    private final GeoDataRepository geoDataRepository;
    private final TrackRepository trackRepository;
    private final SensorRepository sensorRepository;

    public List<GeoData> findByTrack (Long id) {
        Optional<Track> track = trackRepository.findById(id);
        Sensor sensor = track.get().getSensorId();
        return geoDataRepository.findBySensorId(sensor);
    }

    public List<GeoData> findAll() {
        return geoDataRepository.findAll();
    }
    public List<GeoData> findBySensor (Long id) {
        Optional<Sensor> sensor = sensorRepository.findById(id);
        Sensor sensor1 = new Sensor();
        sensor1.setId(sensor1.getId());
        sensor1.setImei(sensor1.getImei());
        sensor1.setUserId(sensor1.getUserId());
        return geoDataRepository.findBySensorId(sensor1);
    }

    public Optional<GeoData> findById (Long id) {
        return geoDataRepository.findById(id);
    }
}
