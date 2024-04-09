package mapsence.service;

import lombok.RequiredArgsConstructor;
import mapsence.dto.UserEditDTO;
import mapsence.model.GeoData;
import mapsence.model.User;
import mapsence.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
    }

    public User editUser(Long id, UserEditDTO userEditDTO) {
        User user = userRepository.findById(id).orElseThrow();
        user.setLogin(userEditDTO.login());
        user.setPass(userEditDTO.password());

        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}