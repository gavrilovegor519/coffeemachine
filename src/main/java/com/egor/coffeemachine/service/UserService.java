package com.egor.coffeemachine.service;

import com.egor.coffeemachine.dto.TokenDto;
import com.egor.coffeemachine.dto.UserDto;

/**
 * User management service layer. User can login and register.
 * @author Egor Gavrilov (gavrilovegor519@gmail.com)
 */
public interface UserService {

    /**
     * Login user and return JWT Bearer token.
     * @param userDto Login data
     * @return JWT Bearer token
     */
    TokenDto login(UserDto userDto);

    /**
     * Register new user.
     * @param userDto Registration data
     */
    void reg(UserDto userDto);
}
