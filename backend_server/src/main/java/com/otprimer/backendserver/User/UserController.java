package com.otprimer.backendserver.User;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public @ResponseBody Iterable<UserModel> getUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> findUserById(@PathVariable(value = "id") String id) {
        Optional<UserModel> user = userRepository.findById(id);

        if(user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path="/new")
    public UserModel saveNewUser(@Validated @RequestBody UserModel user) {
        Optional<UserModel> newuser = userRepository.findById(user.getId());

        if(newuser.isPresent()) {
            return newuser.get();
        }
        else{
            return userRepository.save(user);
        }
    }
    @PostMapping
    public UserModel saveUser(@Validated @RequestBody UserModel user) {
        return userRepository.save(user);
    }

}
