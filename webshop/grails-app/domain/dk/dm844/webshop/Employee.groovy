package dk.dm844.webshop

class Employee extends Person {

    static hasMany = [orders : Order]

    static constraints = {
    }
}
