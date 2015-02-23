package dk.dm844.webshop

class Order {

    int id
    Date dateCreated
    Date lastUpdated
    static hasMany = [orderEntries : OrderEntry]
    static belongsTo = [customer : Customer, employee : Employee]


    static constraints = {
    }
}
