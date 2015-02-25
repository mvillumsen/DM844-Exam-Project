package dk.dm844.webshop

class Customer {

    Date dateCreated
    Date lastUpdated
    static hasOne = [credentials : Person]
    static hasMany = [orders : Order]

    static constraints = {
    }
}
