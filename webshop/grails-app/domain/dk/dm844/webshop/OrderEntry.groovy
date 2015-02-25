package dk.dm844.webshop

class OrderEntry {

    int id
    int amount
    int price
    Date dateCreated
    Date lastUpdated
    static belongsTo = [order : Order, product : Product]

    static constraints = {
        amount min: 1
    }
}
