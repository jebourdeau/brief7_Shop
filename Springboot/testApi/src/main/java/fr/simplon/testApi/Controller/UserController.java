package fr.simplon.testApi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.testApi.Models.User;
import fr.simplon.testApi.repositories.UserRepository;


@RestController
@RequestMapping("/testApi/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    @GetMapping("/{userId}")
    public Optional<User> getOneUsers(@PathVariable Integer userId) {
        return userRepository.findById(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        User newUser = new User(user.getUsername());
        return userRepository.save(newUser);
    }

    @GetMapping("/hello/{username}")
    public String helloUser(@PathVariable String username){
        return "Hello, " + username;
    }


}
