package mapsence.controller;

import lombok.RequiredArgsConstructor;
import mapsence.dto.UserEditDTO;
import mapsence.model.User;
import mapsence.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findUser(@PathVariable Long id) {
        User user = userService.findUser(id);
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<User> editUser(@PathVariable Long id, @RequestBody UserEditDTO userEditDTO) {
        User user = userService.editUser(id, userEditDTO);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> allUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
}
