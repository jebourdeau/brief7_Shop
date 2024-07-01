package fr.simplon.testApi.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.testApi.Exceptions.UndefiniedException;
import fr.simplon.testApi.Messages.MessageCreatePanier;
import fr.simplon.testApi.Models.Articles;
import fr.simplon.testApi.Models.Panier;
import fr.simplon.testApi.repositories.ArticleRepository;
import fr.simplon.testApi.repositories.PanierRepository;
import fr.simplon.testApi.repositories.UserRepository;

@RestController

public class PanierController {
    @Autowired
    private PanierRepository panierRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @PostMapping("/panier")

    public Panier generatedPanier(
        @RequestBody MessageCreatePanier panierDTO) throws UndefiniedException {
        Panier panier = new Panier();
        
        panier.setUser(userRepository.findById(panierDTO.getUser()).orElseThrow(()-> new UndefiniedException("User not Found")));
        panier.getArticles().add(articleRepository.findById(panierDTO.getArticle()).orElseThrow(()-> new UndefiniedException("article not found")));

            
        // panier.getListArticle()= new Panier();
        return panierRepository.save(panier);
    }

    @GetMapping("/{id}")
    public Optional<Panier> getPanier(@PathVariable Integer id){
        return panierRepository.findById(id);
    }

    @PutMapping("/{id}/articles")
    public Panier setPanier(@PathVariable Integer id, @RequestBody Articles article) throws UndefiniedException {
        Panier panier = panierRepository.findById(id).orElseThrow(()-> new UndefiniedException("Panier not found"));

        Articles newArticles = articleRepository.findById(article.getId()).orElseThrow(()-> new UndefiniedException("Panier not found"));
        panier.getArticles().add(newArticles);

        return panier;
    }

    @DeleteMapping("/{id}")
    public void setArticles(@PathVariable Integer id){
        panierRepository.deleteById(id);
    }

}
