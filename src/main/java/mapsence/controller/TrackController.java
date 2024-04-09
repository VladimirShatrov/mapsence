package mapsence.controller;

import lombok.RequiredArgsConstructor;
import mapsence.model.Track;
import mapsence.service.TrackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/track")
@RequiredArgsConstructor
public class TrackController {
    private final TrackService trackService;

    @GetMapping("/user_track/{user_id}")//вывод всех треков пользователя
    public List<Track> findByUserId (@PathVariable Long user_id) {
        return trackService.findByUserId(user_id);
    }

    //@GetMapping("/coordinates/{track_id}") - вывод всех точек трека
}
