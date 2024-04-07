package mapsence.repository;

import mapsence.model.Sensor;
import mapsence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SensorRepository extends JpaRepository<Sensor, Long> {
    Sensor findByUserId(User user);
}
