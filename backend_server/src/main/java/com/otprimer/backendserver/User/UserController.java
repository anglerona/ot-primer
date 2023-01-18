package com.otprimer.backendserver.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public Iterable<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    @PostMapping("/")
    public User addUser(@RequestBody User user){
        User newUser = this.userRepository.save(user);
        return newUser;
    }

    @PutMapping("/{id}/change/username")
    public User changeUsername(@PathVariable("id") Integer id, @RequestBody User user){
        Optional<User> optionalUser = this.userRepository.findById(id);
        if(!optionalUser.isPresent()){
            return null;
        }
        User newUsername = optionalUser.get();
        newUsername.setUserName(user.getUserName());
        User newUser = this.userRepository.save(newUsername);
        return newUser;
    }


    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable("id") Integer id){
        Optional<User> optUser = this.userRepository.findById(id);
        if(!optUser.isPresent()){
            return null;
        }
        User userToDelete = optUser.get();
        this.userRepository.delete(userToDelete);
        return userToDelete;
    }

}
