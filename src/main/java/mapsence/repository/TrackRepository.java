package mapsence.repository;

import mapsence.model.Sensor;
import mapsence.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {
    List<Track> findBySensorId(Sensor sensor);
}
//Если у track появится связь с user - дописать findByUserId