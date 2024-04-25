package mapsence.repository;

import mapsence.model.Sensor;
import mapsence.model.Track;
import mapsence.model.TrackPointInfo;
import mapsence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {
    List<Track> findBySensorId(Long sensorId);
    List<Track> findByUserId(Long userId);
}