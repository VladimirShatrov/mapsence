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

    @JoinColumn(name = "track_id")
    private Long trackId;
    private double latitude;
    private double longitude;
    private double height;

    @JoinColumn(name = "sensor_id")
    private Long sensorId;
}
