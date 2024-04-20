package mapsence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "v_track_info", schema = "zxc")
public class TrackPointInfo {
    @Id
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @Column(name = "track_id")
    private Long trackId;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "height")
    private double height;

    @Column(name = "sensor_id")
    private Long sensorId;

    public TrackPointInfo(Long id, double latitude, double longitude, double height, Long sensorId) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
        this.sensorId = sensorId;
    }
}
