package fr.simplon.testApi.Controller;

import java.util.InputMismatchException;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.testApi.Exceptions.InvalidCredentialException;
import fr.simplon.testApi.Models.User;
import fr.simplon.testApi.repositories.UserRepository;

@RestController

public class LoginController {
    
    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public User createUser(
            @ModelAttribute("username") String username,
            @ModelAttribute("password") String password
            )throws InvalidCredentialException {
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(
            ()-> new InvalidCredentialException("Check your credential"));

    }

    @PostMapping("/register")
    public User createUser(
            @ModelAttribute("username") String username,
            @ModelAttribute("password") String password,
            @ModelAttribute("passwordConfirm") String passwordConfirm,
            @ModelAttribute("email") String email) {

        if (password.equals(passwordConfirm)) {
            User user = new User(username);
            user.setEmail(email);
            user.setPassword(password);
            return userRepository.save(user);
        } else {
            throw new InputMismatchException("Passwords didn't match");
        }
    }

}
