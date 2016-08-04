package com.unnormal.web.api;

import com.unnormal.service.UserService;
import com.unnormal.service.dto.UserDto;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

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


    @RequestMapping(value = "/find/{email}", method = RequestMethod.GET)
    public List<UserDto> get(@PathVariable("email") String email) {
        System.out.print(email);
        List<UserDto> users = userService.findByEmail(email);
        return users;
    }

}
