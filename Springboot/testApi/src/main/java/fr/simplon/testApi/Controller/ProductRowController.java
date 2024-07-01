package fr.simplon.testApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.testApi.repositories.PanierRepository;

@RestController
public class ProductRowController {
    @Autowired
    PanierRepository panierRepository;
    
}
