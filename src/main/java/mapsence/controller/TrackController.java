package mapsence.controller;

import lombok.RequiredArgsConstructor;
import mapsence.model.GeoData;
import mapsence.model.Sensor;
import mapsence.model.Track;
import mapsence.repository.GeoDataRepository;
import mapsence.service.TrackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracks")
@RequiredArgsConstructor
public class TrackController {
    private final TrackService trackService;
    private final GeoDataRepository geoDataRepository;

    /*@GetMapping("/{id}")
    public List<GeoData> coordinates(@PathVariable Long id) {
        Track track = trackService.findTrack(id);
        Sensor sensor = track.getSensor_id();
        List<GeoData> geoData = geoDataRepository.findBySensor_id(sensor.getId());
        return geoData;
    }*/

}
