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
@Table(name = "v_tracks_view", schema = "zxc")
public class TrackView {
    @Id
    @Column(name = "id", insertable = false, updatable = false)
    private int id;

    private String name;
    private Date date_start;
    private Date date_stop;
    private int sensorId;
    private int userId;
    private float distance;
    private float avgSpeed;
    private String duration;
}
