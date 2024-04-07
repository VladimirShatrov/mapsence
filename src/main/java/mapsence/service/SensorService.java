package mapsence.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mapsence.dto.AddTrackRequest;
import mapsence.model.Sensor;
import mapsence.model.Track;
import mapsence.model.User;
import mapsence.repository.SensorRepository;
import mapsence.repository.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SensorService {
    private final SensorRepository sensorRepository;

    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }
}
