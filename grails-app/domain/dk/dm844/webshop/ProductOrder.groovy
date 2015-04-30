package dk.dm844.webshop

class ProductOrder {

    enum Status {
        UNASSIGNED, OPEN, COMPLETED, CLOSED

        String toString() {
            switch (this) {
                case UNASSIGNED: return "UNASSIGNED"
                case OPEN: return "OPEN"
                case COMPLETED: return "COMPLETED"
                case CLOSED: return "CLOSED"
                default: return ""
            }
        }
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
    }

    static mapping = {
        orderEntries cascade: "all-delete-orphan"
    }

    @Override
    String toString() {
        return "Order no.: $id"
    }

}
