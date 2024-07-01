package fr.simplon.testApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.testApi.Messages.MessageCreateOrder;
import fr.simplon.testApi.Models.Orders;
import fr.simplon.testApi.Models.Panier;
import fr.simplon.testApi.repositories.OrderRepository;
import fr.simplon.testApi.repositories.PanierRepository;


@RestController
public class OrdersController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PanierRepository panierRepository;
    
    
    @PostMapping("/order")
    public Orders createOrders(

        @RequestBody MessageCreateOrder orders)throws Exception{
            
            Panier panierFinal = panierRepository.findById(orders.getPanier()).orElseThrow(()->new Exception("votre panier est vide"));
            Orders order =  new Orders();
            
            order.setUser(panierFinal.getUser());
            order.getArticles().addAll(panierFinal.getArticles());
            return orderRepository.save(order);
        }



}
