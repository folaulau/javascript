package com.lovemesomecoding.user;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    @Override
    public User signup(User user) {
        log.info("signup {}", user.toString());
        long id = new Random().nextLong();

        if (id < 0) {
            id = id * -1;
        }

        user.setId(id);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return user;
    }

    @Override
    public User getUserById(Long id) {
        User user = new User();
        user.setId(id);
        user.setFirstName("Folau");
        user.setLastName("Kaveinga");
        user.setEmail("folaukaveinga@gmail.com");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return user;

    }

    @Override
    public User update(User user) {
        user.setFirstName("Folau");
        user.setLastName("The programmer");
        user.setEmail("folaukaveinga@gmail.com");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        if (true) {
            throw new IllegalAccessError("Cannot access this endpoint");
        }

        return user;

    }

}
