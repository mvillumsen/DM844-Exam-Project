package dk.dm844.webshop

class ProductOrder {

    enum Status {
        CREATED, PACKING, READY_TO_SHIP, DELIVIERING, DELIVERED

        String toString() {
            switch (this) {
                case CREATED: return "Created"
                case PACKING: return "Packing"
                case READY_TO_SHIP: return "Ready to ship"
                case DELIVIERING: return "Delivering"
                case DELIVERED: return "Delivered"
                default: return ""
            }
        }
    }

    Status status = Status.CREATED
    Address alternativeAddress
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
