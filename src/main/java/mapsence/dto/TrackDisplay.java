package mapsence.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrackDisplay {
    private int id;
    private String name;
    private String date_start;
    private String date_stop;
    private int sensorId;
    private int userId;
    private float distance;
    private float avgSpeed;
    private String duration;
}
