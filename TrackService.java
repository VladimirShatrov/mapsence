package mapsence.service;

import lombok.RequiredArgsConstructor;
import mapsence.model.Sensor;
import mapsence.model.Track;
import mapsence.model.User;
import mapsence.repository.SensorRepository;
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

    public Track findTrack(Long id) {
        return trackRepository.findById(id).orElseThrow();
    }

    public List<Track> findByUserId(Long user_id) {
        Optional<User> user = userRepository.findById(user_id);
        return trackRepository.findByUserId(user.orElseThrow(() -> new NoSuchElementException("User not found with id: " + user_id)));
    }

    //по мере продвижения добавить создание и удаление трека

}
