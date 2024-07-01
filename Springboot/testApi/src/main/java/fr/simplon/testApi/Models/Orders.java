package fr.simplon.testApi.Models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private User user;
    private LocalDateTime dateTime;
    @ManyToMany
    private List<Articles> articles;
    

    public Orders(){};
}
