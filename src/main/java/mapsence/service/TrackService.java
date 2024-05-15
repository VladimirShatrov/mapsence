package mapsence.service;

import lombok.RequiredArgsConstructor;
import mapsence.dto.TrackDisplay;
import mapsence.model.*;
import mapsence.repository.*;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
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

    public List<TrackDisplay> findByUserId(int user_id) {
        List<TrackView> views = trackViewRepository.findByUserId(user_id);
        List<TrackDisplay> displays = new ArrayList<>();
        for (TrackView view: views) {
            TrackDisplay trackDisplay = new TrackDisplay();
            trackDisplay.setUserId(view.getUserId());
            trackDisplay.setAvgSpeed(view.getAvgSpeed());
            trackDisplay.setDistance(view.getDistance());
            trackDisplay.setDuration(view.getDuration());
            trackDisplay.setId(view.getId());
            trackDisplay.setName(view.getName());
            trackDisplay.setSensorId(view.getSensorId());

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();

            if (view.getDate_start() != null) {
                Date date_start = view.getDate_start();
                calendar.setTime(date_start);
                calendar.add(Calendar.HOUR_OF_DAY, 5);
                date_start = calendar.getTime();
                String date_st = simpleDateFormat.format(date_start);
                trackDisplay.setDate_start(date_st);
            }
            else {
                trackDisplay.setDate_start("нет времени начала");
            }

            if (view.getDate_stop() != null) {
                Date date_stop = view.getDate_stop();
                calendar.setTime(date_stop);
                calendar.add(Calendar.HOUR_OF_DAY, 5);
                date_stop = calendar.getTime();
                String date_finish = simpleDateFormat.format(date_stop);
                trackDisplay.setDate_stop(date_finish);
                displays.add(trackDisplay);
            }
            else {
                trackDisplay.setDate_stop("нет времени конца");
                displays.add(trackDisplay);
            }

        }
        return displays;
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

    public void startTrack(Instant dateStart, int sensorId, int userId, String name) {
        trackRepository.prc_track_start(dateStart, sensorId, userId, name);
    }

    public void stopTrack(int trackId, Instant dateStop) {
        trackRepository.prc_track_stop(trackId, dateStop);
    }

    public void trackComeback(int trackId) {
        trackRepository.prc_track_comeback(trackId);
    }
}