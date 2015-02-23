package dk.dm844.webshop

class Customer extends Person {

    static hasMany = [orders : Order]

    static constraints = {
    }
}
