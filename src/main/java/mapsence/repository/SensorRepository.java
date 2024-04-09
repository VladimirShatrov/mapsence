package mapsence.repository;

import mapsence.model.Sensor;
import mapsence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SensorRepository extends JpaRepository<Sensor, Long> {
    Sensor findByUserId(User user);
}
