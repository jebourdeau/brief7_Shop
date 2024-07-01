package fr.simplon.testApi.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import fr.simplon.testApi.Models.User;
import fr.simplon.testApi.repositories.UserRepository;


@Component
public class DataLoader implements ApplicationRunner{
    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void run (ApplicationArguments args){
        userRepository.save(new User("Patate"));
    }

}
