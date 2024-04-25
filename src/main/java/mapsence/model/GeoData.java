package mapsence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (schema = "zxc", name = "geo_data")
public class GeoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false)
    private Long id;

    @JoinColumn(name = "sensor_id")
    private Long sensorId;
    private double latitude;
    private double longitude;
    private double height;
    private double speed;
    private Date date_time;
    private double course;
    private double battery_voltage;
    private BigDecimal satellite_count;
    private byte[] geom;
}
