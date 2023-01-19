package com.walkwithmydog.walkwithmydog.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.walkwithmydog.walkwithmydog.dog.Dog;
import com.walkwithmydog.walkwithmydog.dog.DogRepository;
import com.walkwithmydog.walkwithmydog.user.User;
import com.walkwithmydog.walkwithmydog.user.UserRepository;
import com.walkwithmydog.walkwithmydog.utils.dog.Gender;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DogRepository dogRepository;
    private final UserRepository userRepository;

    public DataInitializer(DogRepository dogRepository, UserRepository userRepository) {
        this.dogRepository = dogRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {

        User user1 = new User("sony", "cava", "sony@gmail.com");
        User user2 = new User("sam", "caleo", "sam@gmail.com");
        Dog sony = new Dog("savo", Gender.MALE);
        Dog sam = new Dog("samio", Gender.FEMALE);
        dogRepository.saveAll(List.of(sony, sam));

        user1.setDog(sony);
        sony.setUser(user1);

        user2.setDog(sam);
        sam.setUser(user2);

        userRepository.save(user1);
        dogRepository.save(sony);

        userRepository.save(user2);
        dogRepository.save(sam);
    }
}