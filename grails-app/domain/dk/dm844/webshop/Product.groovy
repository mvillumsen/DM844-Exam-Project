package dk.dm844.webshop

import com.metasieve.shoppingcart.Shoppable

class Product extends Shoppable {

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
        // TODO: Solve issue with product names consisting of multiple words
        // Husk at slette TODO statements, vis de er løst
        return "http://lorempixel.com/150/150/food/${name.encodeAsHTML()}"
    }

    @Override
    String toString() {
        return name
    }
}
