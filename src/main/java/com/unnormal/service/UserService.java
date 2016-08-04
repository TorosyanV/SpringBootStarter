package com.unnormal.service;

import com.unnormal.data.entity.UserEntity;
import com.unnormal.service.dto.UserDto;

import java.util.List;

/**
 * Created by Vazgen on 08/02/2016.
 */
public interface UserService {
    long add(UserDto user);
    UserDto getById(long id);
    List<UserDto> findByEmail(String email);
}
