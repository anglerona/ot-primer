package com.otprimer.backendserver.User;

import com.otprimer.backendserver.Comment.Comment;
import com.otprimer.backendserver.Comment.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Iterable<User> findAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public User saveUser(@Validated @RequestBody User user) {
        
        return userRepository.save(user);
    }

    @PostMapping(path="/new")
    public User saveNewUser(@Validated @RequestBody User user) {
        Optional<User> newuser = userRepository.findById(user.getId());

        if(newuser.isPresent()) {
            return newuser.get();
        }
        else{
            return userRepository.save(user);
        }
    }



    @PutMapping("/{id}/change/username")
    public User changeUsername(@PathVariable("id") String id, @RequestBody User user){
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
    public User deleteUser(@PathVariable("id") String id){
        Optional<User> optUser = this.userRepository.findById(id);
        if(!optUser.isPresent()){
            return null;
        }
        User userToDelete = optUser.get();
        this.userRepository.delete(userToDelete);
        return userToDelete;
    }

}
