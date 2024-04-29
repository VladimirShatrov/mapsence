package mapsence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "zxc", name = "track")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable=false, updatable=false)
    private Long id;
    private Date date_start;
    private Date date_stop;
    private String name;

    @JoinColumn(name = "sensor_id")
    private Long sensorId;
    @JoinColumn(name = "user_id")
    private Long userId;
}
