package mapsence.service;

import lombok.RequiredArgsConstructor;
import mapsence.model.Track;
import mapsence.repository.TrackRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrackService {
    private final TrackRepository trackRepository;

    public Track findTrack(Long id) {
        return trackRepository.findById(id).orElseThrow();
    }

}
