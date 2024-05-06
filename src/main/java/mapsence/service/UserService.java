package mapsence.service;

import lombok.RequiredArgsConstructor;
import mapsence.model.User;
import mapsence.repository.UserRepository;
import org.springframework.stereotype.Service;


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

    public List<User> findAll() {
        return userRepository.findAll();
    }
}