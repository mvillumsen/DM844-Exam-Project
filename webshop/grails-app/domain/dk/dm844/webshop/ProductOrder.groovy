package dk.dm844.webshop

class ProductOrder {

    enum Status {
        UNASSIGNED, OPEN, COMPLETED, CLOSED
    }

    Status status = Status.UNASSIGNED
    Date dateCreated
    Date lastUpdated
    static hasMany = [orderEntries : OrderEntry]
    static belongsTo = [customer : Customer, assignedEmployee: Employee]

    static constraints = {
        assignedEmployee nullable: true
	    orderEntries nullable: true
    }

    @Override
    String toString() {
        return "Order no.: $id"
    }
}
