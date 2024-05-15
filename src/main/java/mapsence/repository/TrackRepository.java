package mapsence.repository;

import mapsence.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
    List<Track> findBySensorId(Long sensorId);
    List<Track> findByUserId(Long userId);

    @Procedure(procedureName = "zxc.prc_delete_track")
    void prc_delete_track(int id);

    @Procedure(procedureName = "zxc.prc_edit_track")
    void prc_edit_track(int id, String name);

    @Procedure(procedureName = "zxc.prc_track_action")
    void prc_track_start(Instant dateStart, int sensorId, int userId, String name);

    @Procedure(procedureName = "zxc.prc_track_end")
    void prc_track_stop(int id, Instant dateStop);

    @Procedure(procedureName = "zxc.prc_track_comeback")
    void prc_track_comeback(int id);


}