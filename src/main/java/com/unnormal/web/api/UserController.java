package com.unnormal.web.api;

import com.unnormal.service.UserService;
import com.unnormal.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Vazgen on 08/02/2016.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public UserDto insert(@RequestBody UserDto user) {

//dto should map from viewmodel
        userService.add(user);
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDto get(@PathVariable("id") long id) {
        UserDto user = userService.getById(id);
        return user;
    }

}
