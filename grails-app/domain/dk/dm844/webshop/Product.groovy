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

    String getPicture() {
        String str = name.replaceAll(/[^A-Za-z0-9_ ]/, "")
        return "http://lorempixel.com/150/150/food/${str}"
    }

    @Override
    String toString() {
        return name
    }
}
