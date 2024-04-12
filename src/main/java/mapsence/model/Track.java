package mapsence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


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
    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensorId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    //могут появиться доп поля такие как average speed, название трека, длительность и проеденный путь
}
