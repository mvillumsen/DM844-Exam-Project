package dk.dm844.webshop

class ProductOrder {

    enum Status {
        NEW, PACKING, PACKED, DELIVERING, COMPLETED
    }

    Status status = Status.NEW
    Address address
    Date dateCreated
    Date lastUpdated
    static hasMany = [orderEntries : OrderEntry]
    static belongsTo = [customer : Person, assignedEmployee: Person]

    static constraints = {
        assignedEmployee nullable: true
	    orderEntries nullable: true
    }

    static mapping = {
        orderEntries cascade: "all-delete-orphan"
    }

    @Override
    String toString() {
        return "Order no.: $id"
    }
}
