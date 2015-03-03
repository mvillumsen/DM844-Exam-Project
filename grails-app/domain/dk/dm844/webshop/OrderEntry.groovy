package dk.dm844.webshop

class OrderEntry {

    int amount
    int price
    Date dateCreated
    Date lastUpdated
    static belongsTo = [order : ProductOrder, product : Product]

    static constraints = {
        amount min: 1
    }

    @Override
    String toString() {
        return "Order entry: $id"
    }
}
