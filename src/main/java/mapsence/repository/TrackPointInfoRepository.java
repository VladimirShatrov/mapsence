package mapsence.repository;

import mapsence.model.TrackPointInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackPointInfoRepository extends JpaRepository<TrackPointInfo, Long> {
    List<TrackPointInfo> findByTrackIdOrderByDateTime(Long trackId);
}
