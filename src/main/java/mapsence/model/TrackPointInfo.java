package mapsence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Immutable;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Immutable
@Table(name = "v_track_info", schema = "zxc")
public class TrackPointInfo {
    @Id
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    private double latitude;
    private double longitude;
    private double height;
    private Date dateTime;
    private double speed;

    @JoinColumn(name = "sensor_id")
    private Long sensorId;
    @JoinColumn(name = "track_id")
    private Long trackId;
}
