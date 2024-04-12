package mapsence.repository;

import mapsence.model.Sensor;
import mapsence.model.Track;
import mapsence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {
    List<Track> findBySensorId(Sensor sensor);
    List<Track> findByUserId(User user);
}
//Если у track появится связь с user - дописать findByUserId