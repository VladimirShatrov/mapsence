package mapsence.repository;

import mapsence.model.TrackPointInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackPointInfoRepository extends JpaRepository<TrackPointInfo, Long> {
    List<TrackPointInfo> findByTrackIdOrderByDateTime(Long trackId);
}
