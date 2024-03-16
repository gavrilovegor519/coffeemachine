package com.egor.coffeemachine.service.impl;

import com.egor.coffeemachine.dto.UserDto;
import com.egor.coffeemachine.entity.User;
import com.egor.coffeemachine.exception.DuplicateUserException;
import com.egor.coffeemachine.exception.IncorrectPasswordException;
import com.egor.coffeemachine.exception.UserNotFoundException;
import com.egor.coffeemachine.repo.UserRepo;
import com.egor.coffeemachine.security.JwtUtilities;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private JwtUtilities jwtUtilities;

    @Mock
    private UserRepo userRepository;

    @Spy
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void loginWithExistUser() throws UserNotFoundException, IncorrectPasswordException {
        var userDto = new UserDto();
        userDto.setUsername("testuser");
        userDto.setPassword("test");

        var user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));

        userService.login(userDto);
    }

    @Test
    void loginWithExistUserButWithIncorrectPassword() {
        var userDto = new UserDto();
        userDto.setUsername("testuser");
        userDto.setPassword("test");

        var user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode("test2"));

        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));

        assertThrows(IncorrectPasswordException.class, () -> userService.login(userDto));
    }

    @Test
    void loginWithNotExistUser() {
        var userDto = new UserDto();
        userDto.setUsername("testuser");

        assertThrows(UserNotFoundException.class, () -> userService.login(userDto));
    }

    @Test
    void registrationWithDuplicatedUser() {
        var userData = new UserDto();
        userData.setUsername("testuser");

        when(userRepository.existsByUsername(any())).thenReturn(true);

        assertThrows(DuplicateUserException.class, () -> userService.reg(userData));
    }
}