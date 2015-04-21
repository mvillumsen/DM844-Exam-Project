package dk.dm844.webshop

class ProductOrder {

    enum Status {
        UNASSIGNED, OPEN, COMPLETED, CLOSED
    }

    Status status = Status.UNASSIGNED
    Address address
    Date dateCreated
    Date lastUpdated
    static hasMany = [orderEntries : OrderEntry]
    static belongsTo = [customer : Person, assignedEmployee: Person]

    static constraints = {
        assignedEmployee nullable: true
	    orderEntries nullable: true
        address nullable: true
    }

    static mapping = {
        orderEntries cascade: "all-delete-orphan"
    }

    @Override
    String toString() {
        return "Order no.: $id"
    }
}
