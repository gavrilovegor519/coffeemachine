package com.egor.coffeemachine.service.impl;

import com.egor.coffeemachine.dto.TokenDto;
import com.egor.coffeemachine.dto.UserDto;
import com.egor.coffeemachine.entity.User;
import com.egor.coffeemachine.exception.DuplicateUserException;
import com.egor.coffeemachine.exception.IncorrectPasswordException;
import com.egor.coffeemachine.exception.UserNotFoundException;
import com.egor.coffeemachine.mapper.UserMapper;
import com.egor.coffeemachine.repo.UserRepo;
import com.egor.coffeemachine.security.JwtUtilities;
import com.egor.coffeemachine.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final JwtUtilities jwtUtilities;
    private final UserRepo userRepository;
    private final UserMapper registrationDataInputMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public TokenDto login(UserDto userDto) {
        String username = userDto.getUsername();
        String password = userDto.getPassword();

        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found."));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IncorrectPasswordException("Incorrect password!");
        }

        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(jwtUtilities.generateToken(user.getUsername(), "ROLE_USER"));
        return tokenDto;
    }

    @Override
    public void reg(UserDto userDto) {
        boolean emailIsExist =
                userRepository.existsByUsername(userDto.getUsername());

        if (emailIsExist) {
            throw new DuplicateUserException("Duplicate E-Mail.");
        }

        User user = registrationDataInputMapper.map(userDto);
        userRepository.save(user);
    }
}
