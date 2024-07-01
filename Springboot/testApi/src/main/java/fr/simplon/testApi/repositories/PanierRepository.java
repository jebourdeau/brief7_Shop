package fr.simplon.testApi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.testApi.Models.Panier;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Integer>{
    
}
