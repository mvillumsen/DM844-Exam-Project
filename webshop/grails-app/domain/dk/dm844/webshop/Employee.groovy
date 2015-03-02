package dk.dm844.webshop

class Employee {

    int salary
    Date dateHired
    Date dateCreated
    Date lastUpdated
    static belongsTo = [credentials : Person]
    static hasMany = [assignedOrders : ProductOrder]

    static constraints = {

    }

    @Override
    String toString() {
        return credentials.name
    }
}
