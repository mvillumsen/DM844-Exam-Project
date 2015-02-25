package dk.dm844.webshop

class Customer {

    int id
    Date dateCreated
    Date lastUpdated
    static belongsTo = [credentials : Person]
    static hasMany = [orders : Order]

    static constraints = {

    }
}
