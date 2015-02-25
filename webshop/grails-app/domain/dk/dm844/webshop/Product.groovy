package dk.dm844.webshop

class Product {

    int id
    String name
    int price
    String description
    int stock
    Date dateCreated
    Date lastUpdated
    static belongsTo = [category : Category]
    static hasMany = [orderEntries : OrderEntry]

    static constraints = {
        id unique: true, blank: false
        name blank: false
        description nullable: true
    }

    def getPicture() {
        return "http://lorempixel.com/150/150/food/$name"
    }
}
