##Shop springBoot


 ##Installation

 ## contribution

 ### understand the class diagram       : 


classDiagram:
 
 
    class User {
        -Integer id
        -String username
    }
    class Product {
        -Integer id
        -String name
        -Float price
    }
    class Card {
        -Integer id
        -DateTime creationDate
        -Map<Product, Integer> products
    }
    class Order {
        -Integer id
        -DateTime creationDate
        -List<Product> products
    }

## le @Id =  Primary Keys
## le Equals correspond a l'égalité du contenue.


@OnetoMany /@ManyToMany(mappedBy="")
        Le "mappedBy" est l'équivalent d'un InnerJoin en SQL

## @Entity créer une entité exemple le Fichier User =   : 
CREATE TABLE user(
    id NUMBER  serial primarykey,            /* = private Integer id */
    username VARCHAR(255) NOT NULL,          /* = private String username */
    password VARCHAR(255)                    /* = private String password */
)
