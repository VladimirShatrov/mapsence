package mapsence.repository;

import mapsence.model.Sensor;
import mapsence.model.Track;
import mapsence.model.User;
import mapsence.model.TrackPointInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {
    List<Track> findBySensorId(Sensor sensor);
    List<Track> findByUserId(User user);

    @Query("SELECT new mapsence.model.TrackPointInfo(g.id, g.latitude, g.longitude, g.height, g.sensorId.id) FROM GeoData g WHERE g.id = :trackId")
    List<TrackPointInfo> findTrackPointsByTrackId(@Param("trackId") Long trackId);
}


//Если у track появится связь с user - дописать findByUserId