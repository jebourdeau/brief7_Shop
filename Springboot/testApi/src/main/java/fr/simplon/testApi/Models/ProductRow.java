package fr.simplon.testApi.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "productrow")
public class ProductRow {

    @Id
    @GeneratedValue
    private int id;
    private float price;
    private float promo;
    @ManyToOne
    private Articles articles;
    private  Integer quantity;


public ProductRow(){}

}
