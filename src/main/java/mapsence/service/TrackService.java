package mapsence.service;

import lombok.RequiredArgsConstructor;
import mapsence.model.Sensor;
import mapsence.model.Track;
import mapsence.model.TrackPointInfo;
import mapsence.model.User;
import mapsence.repository.SensorRepository;
import mapsence.repository.TrackPointInfoRepository;
import mapsence.repository.TrackRepository;
import mapsence.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrackService {
    private final TrackRepository trackRepository;
    private final SensorRepository sensorRepository;
    private final UserRepository userRepository;
    private final TrackPointInfoRepository trackPointInfoRepository;

    public Track findTrack(Long id) {
        return trackRepository.findById(id).orElseThrow();
    }

    public List<Track> findByUserId(Long user_id) {
        return trackRepository.findByUserId(user_id);
    }

    public List<Track> findAll() {
        return trackRepository.findAll();
    }

    public List<TrackPointInfo> findPointsByTrack(Long trackId) {
        return trackPointInfoRepository.findByTrackId(trackId);
    }
}