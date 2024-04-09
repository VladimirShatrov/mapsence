package mapsence.service;


import lombok.RequiredArgsConstructor;
import mapsence.model.Sensor;
import mapsence.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SensorService {
    private final SensorRepository sensorRepository;

    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }
    //todo findByUserId
}