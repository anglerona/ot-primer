package com.otprimer.backendserver.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController // This allows for automatic response body
@RequestMapping(path="/")
public class UserController{
    @Autowired

    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping(path="/allUsers")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return this.userRepository.findAll();
    }
}