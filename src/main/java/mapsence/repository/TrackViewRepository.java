package mapsence.repository;

import mapsence.model.TrackView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackViewRepository extends JpaRepository<TrackView, Long>{
    List<TrackView> findByUserId(int id);
}
