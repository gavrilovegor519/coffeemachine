package com.egor.coffeemachine.controller;

import com.egor.coffeemachine.dto.TokenDto;
import com.egor.coffeemachine.dto.UserDto;
import com.egor.coffeemachine.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1.0/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public TokenDto login(@RequestBody @Valid UserDto userDto) {
        return userService.login(userDto);
    }

    @PostMapping("/reg")
    public void reg(@RequestBody @Valid UserDto userDto) {
        userService.reg(userDto);
    }
}
