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

    @GetMapping("/sensor/{id}")
    public List<GeoData> findDataBySensor(@PathVariable Long id) {
        return geoDataService.findBySensorId(id);
    }
}
