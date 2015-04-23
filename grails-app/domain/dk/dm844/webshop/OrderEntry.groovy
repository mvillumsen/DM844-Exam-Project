package dk.dm844.webshop

class OrderEntry {

    Integer amount
    Integer price
    Date dateCreated
    Date lastUpdated
    static belongsTo = [order : ProductOrder, product : Product]

    static constraints = {
        amount min: 1
    }

    @Override
    String toString() {
        return "Name: ${product?.name}\t$price\t$amount"
    }

}
