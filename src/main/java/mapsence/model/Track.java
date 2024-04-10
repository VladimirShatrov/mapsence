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
    @JoinColumn(name = "id")
    private Sensor sensorId;//на данный момент в бд serial_id, Дима должен переделать
    //могут появиться доп поля такие как average speed, название трека, длительность и проеденный путь
    //так же нужна связ с user така же как с sensor
}
