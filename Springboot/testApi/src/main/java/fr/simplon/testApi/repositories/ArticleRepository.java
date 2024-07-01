package fr.simplon.testApi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.simplon.testApi.Models.Articles;

@Repository
public interface ArticleRepository extends JpaRepository<Articles,Integer> {

}
