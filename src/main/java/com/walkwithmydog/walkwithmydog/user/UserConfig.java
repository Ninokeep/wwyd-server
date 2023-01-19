package com.walkwithmydog.walkwithmydog.user;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User sony = new User(1L, "sony", "cava", "sony@gmail.com");
            User sam = new User(2L, "sam", "caleo", "sam@gmail.com");
            userRepository.saveAll(
                    List.of(sony, sam));
        };
    }
}