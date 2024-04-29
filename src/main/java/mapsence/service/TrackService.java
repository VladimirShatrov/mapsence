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

import java.util.Date;
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
        return trackPointInfoRepository.findByTrackIdOrderByDateTime(trackId);
    }

    public void deleteTrack(int trackId) {
        trackRepository.prc_delete_track(trackId);
    }

    public void editTrack(int trackId, String name) {
        trackRepository.prc_edit_track(trackId, name);
    }

    public void startTrack(Date dateStart, int sensorId, int userId, String name) {
        trackRepository.prc_track_start(dateStart, sensorId, userId, name);
    }

    public void stopTrack(int trackId, Date dateStop) {
        trackRepository.prc_track_stop(trackId, dateStop);
    }

}