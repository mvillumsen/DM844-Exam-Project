package dk.dm844.webshop

class Employee {

    Integer salary
    Date dateHired
    Date dateCreated
    Date lastUpdated
    Person credentials

    static hasMany = [assignedOrders : ProductOrder]

    static constraints = {
        assignedOrders nullable:true
    }

    @Override
    String toString() {
        return credentials?.name
    }
}
