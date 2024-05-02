package mapsence.service;

import lombok.RequiredArgsConstructor;
import mapsence.model.*;
import mapsence.repository.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TrackService {
    private final TrackRepository trackRepository;
    private final TrackPointInfoRepository trackPointInfoRepository;
    private final TrackViewRepository trackViewRepository;

    public Track findTrack(Long id) {
        return trackRepository.findById(id).orElseThrow();
    }

    public List<TrackView> findByUserId(int user_id) {
        return trackViewRepository.findByUserId(user_id);
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