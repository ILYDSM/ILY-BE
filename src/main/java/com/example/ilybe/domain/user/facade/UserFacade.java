package com.example.ilybe.domain.user.facade;

import com.example.ilybe.domain.user.exception.PasswordMismatchException;
import com.example.ilybe.domain.user.exception.UserExistException;
import com.example.ilybe.domain.user.exception.UserNotFoundException;
import com.example.ilybe.domain.user.domain.User;
import com.example.ilybe.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserFacade {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void checkUserExist(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent())
            throw UserExistException.EXCEPTION;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
    public void checkPassword(User user, String password) {
        if(!passwordEncoder.matches(user.getPassword(), password)) {
            throw PasswordMismatchException.EXCEPTION;
        }
    }

    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByEmail(email);
    }
}