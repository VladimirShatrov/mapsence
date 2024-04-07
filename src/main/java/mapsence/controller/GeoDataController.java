package mapsence.controller;

import lombok.RequiredArgsConstructor;
import mapsence.model.GeoData;
import mapsence.service.GeoDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/geodata")
@RequiredArgsConstructor
public class GeoDataController {
    private final GeoDataService geoDataService;

    @GetMapping("/track/{id}")
    public List<GeoData> findDataByTrack(@PathVariable Long id) {
        return geoDataService.findByTrack(id);
    }

    @GetMapping("/sensor/{id}")
    public List<GeoData> findDataBySensor(@PathVariable Long id) {
        return geoDataService.findBySensor(id);
    }

    @GetMapping("/all")
    public List<GeoData> findAll() {
        return geoDataService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<GeoData> findById(@PathVariable Long id) {
        return geoDataService.findById(id);
    }
}
