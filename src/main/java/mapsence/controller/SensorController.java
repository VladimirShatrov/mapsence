package mapsence.controller;

import lombok.RequiredArgsConstructor;
import mapsence.model.GeoData;
import mapsence.model.Sensor;
import mapsence.service.SensorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensor")
@RequiredArgsConstructor
public class SensorController {
    private final SensorService sensorService;

    @GetMapping("/all")
    public List<Sensor> findAll() {
        return sensorService.findAll();
    }

    @CrossOrigin
    @GetMapping("/current/{sensorId}")
    public GeoData currentGeoData(@PathVariable Long sensorId) {
        return sensorService.currentGeoDataOfSensor(sensorId);
    }

    @CrossOrigin
    @GetMapping("/{userId}")
    public List<Sensor> findByUserId(@PathVariable Long userId) {
        return sensorService.findByUserId(userId);
    }
}