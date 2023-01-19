package com.walkwithmydog.walkwithmydog.user;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User registerUser(User user) {
        Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());
        if (userByEmail.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        userRepository.save(user);
        return user;
    }

    public User deleteUser(Long id) {
        Optional<User> userFound = userRepository.findById(id);
        if (!userFound.isPresent()) {
            throw new IllegalArgumentException("id user not found");
        }
        User user = userFound.get();
        return user;
    }

    public User updateUser(Long id, User user) {
        return userRepository.findById(id).map(
                newUser -> {
                    newUser.setEmail(user.getEmail());
                    newUser.setLastName(user.getLastName());
                    newUser.setName(user.getName());
                    return userRepository.save(newUser);
                }).orElseGet(() -> {
                    return userRepository.save(user);
                });
    }

}