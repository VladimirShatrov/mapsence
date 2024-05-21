package mapsence.service;

import lombok.RequiredArgsConstructor;
import mapsence.model.GeoData;
import mapsence.repository.GeoDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeoDataService {
    private final GeoDataRepository geoDataRepository;

    public List<GeoData> findBySensorId (Long sensor_id) {
        return geoDataRepository.findBySensorId(sensor_id);
    }
}