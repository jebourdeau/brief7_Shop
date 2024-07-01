package fr.simplon.testApi.Models;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;



@Entity
@Data
@Table(name = "panier")

public class Panier {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToMany
    private List<Articles> articles = new ArrayList<>();
    @ManyToOne
    private User user;
    private LocalDateTime date;
    private String deleteArticle;

    
    public Panier(){}
}
