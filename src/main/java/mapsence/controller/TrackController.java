package mapsence.controller;

import lombok.RequiredArgsConstructor;
import mapsence.model.Sensor;
import mapsence.model.Track;
import mapsence.model.TrackPointInfo;
import mapsence.repository.SensorRepository;
import mapsence.service.SensorService;
import mapsence.service.TrackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/track")
@RequiredArgsConstructor
public class TrackController {
    private final TrackService trackService;

    @GetMapping("/user_track/{user_id}")
    public List<Track> findByUserId (@PathVariable Long user_id) {
        return trackService.findByUserId(user_id);
    }

    @GetMapping("/coordinates/{trackId}")
    public List<TrackPointInfo> getTrackCoordinates(@PathVariable Long trackId) {
        return trackService.findPointsByTrack(trackId);
    }

}