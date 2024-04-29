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

import java.time.LocalDate;
import java.util.Date;
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

    @GetMapping("/delete/{trackId}")
    public void deleteTrack(@PathVariable int trackId) {
        trackService.deleteTrack(trackId);
    }

    @GetMapping("/edit/{trackId}/{newName}")
    public void editTrack(@PathVariable int trackId, @PathVariable String newName) {
        trackService.editTrack(trackId, newName);
    }

    @GetMapping("/start/{userId}/{name}/{sensorId}")
    public void startTrack(@PathVariable int userId, @PathVariable int sensorId, @PathVariable String name) {
        Date dateStart = new Date();
        trackService.startTrack(dateStart, sensorId, userId, name);
    }

    @GetMapping("/stop/{trackId}")
    public void stopTrack(@PathVariable int trackId) {
        Date dateStop = new Date();
        trackService.stopTrack(trackId, dateStop);
    }
}