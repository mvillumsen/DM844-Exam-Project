package dk.dm844.webshop

class Product {

    int id
    String name
    int price
    Category category
    String description
    int stock

    static constraints = {
        id unique: true, blank: false
        name blank: false
        price min: 0
        description nullable: true
    }

    def getPicture() {
        return "http://lorempixel.com/150/150/food/$name"
    }
}
