package dk.dm844.webshop

class Product {

    String name
    Integer price
    String description
    Integer stock
    Date dateCreated
    Date lastUpdated
    static belongsTo = [category : Category]
    static hasMany = [orderEntries : OrderEntry]

    static constraints = {
        name blank: false
        description nullable: true
        stock min: 0
    }

    def getPicture() {
        return "http://lorempixel.com/150/150/food/$name"
    }

    @Override
    String toString() {
        return name
    }
}
