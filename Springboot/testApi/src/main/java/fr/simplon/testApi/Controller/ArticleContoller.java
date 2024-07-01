package fr.simplon.testApi.Controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.testApi.Exceptions.InvalidCredentialException;
import fr.simplon.testApi.Models.Articles;
import fr.simplon.testApi.repositories.ArticleRepository;

@RestController

public class ArticleContoller {
    
        private final ArticleRepository articleRepository;

public ArticleContoller(ArticleRepository articleRepository){
    this.articleRepository = articleRepository;
}

    @PostMapping("/articles")
    public Articles createArticles(
        @ModelAttribute("name") String name,
        @ModelAttribute("price") String price
    )throws InvalidCredentialException{
        Articles articles = new Articles();
        articles.setName(name);
        return articleRepository.save(articles);
    }
    @GetMapping
    public List<Articles> getAllArticles(){
        return articleRepository.findAll();
    }

}
