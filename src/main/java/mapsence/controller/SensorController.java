package mapsence.controller;

import lombok.RequiredArgsConstructor;
import mapsence.model.Sensor;
import mapsence.service.SensorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}