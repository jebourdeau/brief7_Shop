package fr.simplon.testApi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.simplon.testApi.Models.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{
} 
