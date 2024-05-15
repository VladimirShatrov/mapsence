package mapsence.controller;

import lombok.RequiredArgsConstructor;
import mapsence.dto.TrackDisplay;
import mapsence.model.Sensor;
import mapsence.model.Track;
import mapsence.model.TrackPointInfo;
import mapsence.model.TrackView;
import mapsence.repository.SensorRepository;
import mapsence.service.SensorService;
import mapsence.service.TrackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/track")
@RequiredArgsConstructor
public class TrackController {
    private final TrackService trackService;

    @CrossOrigin
    @GetMapping("/user_track/{user_id}")
    public List<TrackDisplay> findByUserId (@PathVariable int user_id) {
        return trackService.findByUserId(user_id);
    }

    @CrossOrigin
    @GetMapping("/coordinates/{trackId}")
    public List<TrackPointInfo> getTrackCoordinates(@PathVariable Long trackId) {
        return trackService.findPointsByTrack(trackId);
    }

    @CrossOrigin
    @GetMapping("/delete/{trackId}")
    public void deleteTrack(@PathVariable int trackId) {
        trackService.deleteTrack(trackId);
    }

    @CrossOrigin
    @GetMapping("/edit/{trackId}/{newName}")
    public void editTrack(@PathVariable int trackId, @PathVariable String newName) {
        trackService.editTrack(trackId, newName);
    }

    @CrossOrigin
    @GetMapping("/start/{userId}/{name}/{sensorId}")
    public void startTrack(@PathVariable int userId, @PathVariable int sensorId, @PathVariable String name) {
        Instant dateStart = Instant.now();
        trackService.startTrack(dateStart, sensorId, userId, name);
    }

    @CrossOrigin
    @GetMapping("/stop/{trackId}")
    public void stopTrack(@PathVariable int trackId) {
        Instant dateStop = Instant.now();
        trackService.stopTrack(trackId, dateStop);
    }

    @GetMapping("/comeback/{trackId}")
    public void trackComeback(@PathVariable int trackId) {
        trackService.trackComeback(trackId);
    }

}