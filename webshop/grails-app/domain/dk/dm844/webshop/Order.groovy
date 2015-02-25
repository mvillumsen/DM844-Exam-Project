package dk.dm844.webshop

class Order {

    enum Status {
        UNASSIGNED, OPEN, COMPLETED, CLOSED
    }

    int id
    Status status = Status.UNASSIGNED
    Date dateCreated
    Date lastUpdated
    static hasMany = [orderEntries : OrderEntry]
    static belongsTo = [customer : Customer, assignedEmployee: Employee]

    static constraints = {
        id unique: true, blank: false
        assignedEmployee nullable: true
	orderEntries nullable: true
    }
}
